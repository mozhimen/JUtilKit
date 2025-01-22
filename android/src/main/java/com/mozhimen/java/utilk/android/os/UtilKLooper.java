package com.mozhimen.java.utilk.android.os;

import android.os.Looper;

/**
 * @ClassName UtilKLooper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/10/28
 * @Version 1.0
 */
public class UtilKLooper {
    public static Looper get_ofMain() {
        return getMainLooper();
    }
    public static Looper get_ofMy(){
        return getMyLooper();
    }

    ////////////////////////////////////////////////////////////////////////////

    public static Looper getMainLooper() {
        return Looper.getMainLooper();
    }

    public static Looper getMyLooper() {
        return Looper.myLooper();
    }

    ////////////////////////////////////////////////////////////////////////////

    //是否是MainLooper
    public static boolean isMainLooper() {
        return get_ofMy() == get_ofMain();
    }
}
