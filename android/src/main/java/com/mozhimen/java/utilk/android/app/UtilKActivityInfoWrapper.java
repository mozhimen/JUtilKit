package com.mozhimen.java.utilk.android.app;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;

import androidx.annotation.RequiresPermission;

import com.mozhimen.java.
elemk.android.android.content.cons.CPermission;
import com.mozhimen.java.
utilk.android.content.UtilKIntentWrapper;
import com.mozhimen.java.
utilk.java.UtilKStringWrapper;
import com.mozhimen.java.
utilk.android.content.UtilKPackageManager;

import java.util.List;

/**
 * @ClassName UtilKActivityInfoWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKActivityInfoWrapper {
    //获取启动Activity
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    public static ActivityInfo getMainLauncher(Context context, String strPackageName) {
        if (UtilKStringWrapper.hasSpace(strPackageName) || strPackageName.isEmpty()) return null;
        List<ResolveInfo> resolveInfos = UtilKPackageManager.queryIntentActivities(context, UtilKIntentWrapper.getMainLauncher_ofPackage(strPackageName, null), 0);
        if (resolveInfos.isEmpty()) return null;
        else return resolveInfos.get(0).activityInfo;
    }

    /////////////////////////////////////////////////////////////////////////////////////

    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    public static String getMainLauncherName(Context context, String strPackageName) {
        ActivityInfo activityInfo = getMainLauncher(context, strPackageName);
        if (activityInfo != null) {
            return activityInfo.name;
        } else {
            return "";
        }
    }
}
