package com.mozhimen.java.utilk.android.util;

import android.util.Log;

import com.mozhimen.java.elemk.android.android.util.cons.CLog;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @ClassName UtilKLogWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKLogWrapper {
    private static AtomicBoolean _isLogEnable = new AtomicBoolean(true);


    public static void isLogEnable(boolean enable) {
        _isLogEnable.set(enable);
    }

    public static boolean isLogEnable() {
        return _isLogEnable.get();
    }

    public static void d(String tag, String msg) {
        println(CLog.DEBUG, tag, msg);
    }

    public static void e(String tag, String msg) {
        println(CLog.ERROR, tag, msg);
    }

    public static void e(String tag, String msg, Throwable exception) {
        String message = "";
        if (exception.getMessage() != null)
            message = exception.getMessage();
        println(CLog.ERROR, tag, msg + " " + message);
    }

    public static void println(int level, String tag, String msg) {
        if (!isLogEnable()) {
            return;
        }
        Log.println(level, tag, msg);
    }
}
