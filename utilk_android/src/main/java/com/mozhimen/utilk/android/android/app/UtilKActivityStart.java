package com.mozhimen.utilk.android.android.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.RequiresPermission;

import com.mozhimen.elemk.android.android.content.cons.CPermission;
import com.mozhimen.elemk.android.android.os.cons.CVersCode;
import com.mozhimen.utilk.android.android.content.UtilKContextStart;
import com.mozhimen.utilk.android.android.content.UtilKIntentWrapper;
import com.mozhimen.utilk.android.android.os.UtilKBuildVersion;
import com.mozhimen.utilk.android.java.lang.UtilKRuntimeWrapper;

import java.io.File;

/**
 * @ClassName UtilKLaunchActivity
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:07
 * @Version 1.0
 */
public class UtilKActivityStart {
    public static void startByPackageName(Context context, String strPackageName, String activityName) {
        Intent intent = UtilKIntentWrapper.getComponent(strPackageName, activityName);
        UtilKContextStart.startContext(context, intent);
    }

    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    public static boolean startViewInstall(Context context, String strPathNameApk) {
        if (UtilKBuildVersion.isBeforeVersion(CVersCode.V_24_7_N))
            UtilKRuntimeWrapper.exec_chmod_777(strPathNameApk);
        Intent intent = UtilKIntentWrapper.getViewInstall(strPathNameApk);
        if (intent == null) return false;
        UtilKContextStart.startContext(context, intent);
        return true;
    }

    //安装 if sdk >= 24 add provider
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    public static void startViewInstall(Context context, File fileApk) {
        Intent intent = UtilKIntentWrapper.getViewInstall(fileApk);
        if (intent == null) return;
        UtilKContextStart.startContext(context, intent);
    }

    //安装 if sdk >= 24 add provider
    @RequiresPermission(CPermission.REQUEST_INSTALL_PACKAGES)
    public static void startViewInstall(Context context, Uri uriApk) {
        Intent intent = UtilKIntentWrapper.getViewInstall(uriApk);
        UtilKContextStart.startContext(context, intent);
    }
}
