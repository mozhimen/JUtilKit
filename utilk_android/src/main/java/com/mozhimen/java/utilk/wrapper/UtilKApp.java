package com.mozhimen.java.utilk.wrapper;

import android.content.Context;

import androidx.annotation.RequiresPermission;

import com.mozhimen.java.
elemk.android.android.content.cons.CPermission;
import com.mozhimen.java.
utilk.android.content.UtilKContext;
import com.mozhimen.java.
utilk.android.content.UtilKContextStart;
import com.mozhimen.java.
utilk.android.content.UtilKIntentWrapper;
import com.mozhimen.java.
utilk.android.util.UtilKLogWrapper;
import com.mozhimen.java.
utilk.commons.IUtilK;
import com.mozhimen.java.
utilk.java.lang.UtilKSystem;
import com.mozhimen.java.
elemk.android.android.content.cons.CIntent;
import com.mozhimen.java.
utilk.android.os.UtilKProcess;

import android.content.Intent;

/**
 * @ClassName UtilKApp
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKApp implements IUtilK {
    /**
     * 重启App
     */
    @RequiresPermission(CPermission.QUERY_ALL_PACKAGES)
    public static void restartApp(boolean isKillProcess, boolean isValid, Context context) {
        Intent intent = UtilKIntentWrapper.getMainLauncher_ofPackageManger(context, UtilKContext.getPackageName(context));
        if (intent == null) {
            UtilKLogWrapper.e(TAG, "didn't exist launcher activity.");
            return;
        }
        intent.addFlags(CIntent.FLAG_ACTIVITY_CLEAR_TOP | CIntent.FLAG_ACTIVITY_CLEAR_TASK);
        UtilKContextStart.startContext(context, intent);
        if (!isKillProcess) return;
        exitApp(isValid, false);
    }

    /**
     * 退出App
     */
    public static void exitApp(boolean isValid, boolean isGc) {
        if (isGc) UtilKSystem.gc();
        UtilKProcess.killProcess_ofMyPid();//杀掉当前进程,并主动启动新的启动页,以完成重启的动作
        if (isValid)
            System.exit(0);
        else
            System.exit(10);
    }
}
