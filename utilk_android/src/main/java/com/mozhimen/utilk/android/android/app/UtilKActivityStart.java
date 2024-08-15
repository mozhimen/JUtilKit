package com.mozhimen.utilk.android.android.app;

import android.content.Context;
import android.content.Intent;

import com.mozhimen.elemk.android.android.os.cons.CVersCode;
import com.mozhimen.utilk.android.android.content.UtilKContextStart;
import com.mozhimen.utilk.android.android.content.UtilKIntentWrapper;
import com.mozhimen.utilk.android.android.os.UtilKBuildVersion;
import com.mozhimen.utilk.android.java.lang.UtilKRuntimeWrapper;

/**
 * @ClassName UtilKLaunchActivity
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:07
 * @Version 1.0
 */
public class UtilKActivityStart {
    public static void startByPackageName(Context context, String strPackageName, String activityName) {
        Intent intent = UtilKIntentWrapper.getByPackageName(strPackageName, activityName);
        UtilKContextStart.startContext(context, intent);
    }

    public static void startInstall(Context context, String strPathNameApk) {
        if (UtilKBuildVersion.isBeforeVersion(CVersCode.V_24_7_N))
            UtilKRuntimeWrapper.exec_chmod_777(strPathNameApk);
        Intent intent = UtilKIntentWrapper.getViewInstall(context, strPathNameApk);
        if (intent == null) return;
        UtilKContextStart.startContext(context, intent);
    }
}
