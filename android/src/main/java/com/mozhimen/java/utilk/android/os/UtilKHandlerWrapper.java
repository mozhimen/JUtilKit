package com.mozhimen.java.utilk.android.os;

import android.os.Handler;
import android.os.Looper;


/**
 * @ClassName UtilKHandlerWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/28
 * @Version 1.0
 */
public class UtilKHandlerWrapper {
    private static Handler _handler = new Handler(Looper.getMainLooper());

    public static Handler get() {
        return _handler;
    }

    public static void post(Runnable runnable) {
        if (UtilKLooper.isMainLooper()) {
            runnable.run();
        } else {
            _handler.post(runnable);
        }
    }

    public static void postDelayed(long delayMillis, Runnable runnable) {
        _handler.postDelayed(runnable, delayMillis);
    }
}
