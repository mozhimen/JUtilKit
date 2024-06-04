package com.mozhimen.utilk.android.content;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import com.mozhimen.utilk.android.content.UtilKContext;
import com.mozhimen.utilk.android.os.UtilKBuildVersion;

/**
 * @ClassName UtilKPackageManager
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:36
 * @Version 1.0
 */
public class UtilKPackageManager {
    public static PackageManager get(Context context) {
        return UtilKContext.getPackageManager(context);
    }

    public static PackageInfo getPackageInfo(Context context, String strPackageName,int flags) throws PackageManager.NameNotFoundException {
        return get(context).getPackageInfo(strPackageName, flags);
    }

    @SuppressLint("QueryPermissionsNeeded")
    public static boolean areActivityIntent(Context context, Intent intent) {
        if (intent == null) {
            return false;
        }
        // 这里为什么不用 Intent.resolveActivity(intent) != null 来判断呢？
        // 这是因为在 OPPO R7 Plus （Android 5.0）会出现误判，明明没有这个 Activity，却返回了 ComponentName 对象
        PackageManager packageManager = context.getPackageManager();
        if (UtilKBuildVersion.isAfterV_33_13_TIRAMISU()) {
            return !packageManager.queryIntentActivities(intent,
                    PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY)).isEmpty();
        }
        return !packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty();
    }
}
