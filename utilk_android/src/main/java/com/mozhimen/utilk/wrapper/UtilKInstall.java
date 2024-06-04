package com.mozhimen.utilk.wrapper;

import android.content.Context;

import com.mozhimen.utilk.android.app.UtilKActivityStart;

/**
 * @ClassName UtilKInstall
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:17
 * @Version 1.0
 */
public class UtilKInstall {
    private static final String TAG = "UtilKInstall>>>>>";

    /**
     * 手动安装 if sdk >= 24 add provider
     */
    public static void installHand(Context context, String strPathNameApk) {
        UtilKActivityStart.startInstall(context, strPathNameApk);
    }
}
