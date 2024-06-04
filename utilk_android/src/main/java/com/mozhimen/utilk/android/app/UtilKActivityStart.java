package com.mozhimen.utilk.android.app;

import android.content.Context;
import android.content.Intent;
import android.os.Build;

import com.mozhimen.utilk.android.content.UtilKContextStart;
import com.mozhimen.utilk.android.content.UtilKIntent;
import com.mozhimen.utilk.java.lang.UtilKRuntime;

/**
 * @ClassName UtilKLaunchActivity
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:07
 * @Version 1.0
 */
public class UtilKActivityStart {
    public static void startByPackageName(Context context, String strPackageName, String activityName) {
        Intent intent = UtilKIntent.getByPackageName(strPackageName, activityName);
        UtilKContextStart.startContext(context, intent);
    }

    public static void startInstall(Context context, String strPathNameApk) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N)
            UtilKRuntime.chmod777(strPathNameApk);
        Intent intent = UtilKIntent.getInstall(context, strPathNameApk);
        if (intent == null) return;
        UtilKContextStart.startContext(context, intent);
    }
}
