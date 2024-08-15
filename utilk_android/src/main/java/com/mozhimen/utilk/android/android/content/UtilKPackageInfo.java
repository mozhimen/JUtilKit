package com.mozhimen.utilk.android.android.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mozhimen.utilk.android.android.os.UtilKBuildVersion;

/**
 * @ClassName UtilKPackageInfo
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:36
 * @Version 1.0
 */
public class UtilKPackageInfo {
    public static PackageInfo get(Context context, String strPackageName) throws PackageManager.NameNotFoundException {
        return UtilKPackageManager.getPackageInfo(context, strPackageName, PackageManager.GET_ACTIVITIES);
    }

    public static boolean hasPackage(Context context, String strPackageName) {
        try {
            get(context, strPackageName);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    @SuppressLint("QueryPermissionsNeeded")
    public static boolean hasIntent(@NonNull Context context, @Nullable Intent intent) {
        if (intent == null) return false;
        // 这里为什么不用 Intent.resolveActivity(intent) != null 来判断呢？
        // 这是因为在 OPPO R7 Plus （Android 5.0）会出现误判，明明没有这个 Activity，却返回了 ComponentName 对象
        if (UtilKBuildVersion.isAfterV_33_13_TIRAMISU())
            return !UtilKPackageManager.get(context).queryIntentActivities(intent, PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY)).isEmpty();
        return !UtilKPackageManager.get(context).queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty();
    }
}
