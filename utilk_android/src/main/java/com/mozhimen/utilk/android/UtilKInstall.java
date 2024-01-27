package com.mozhimen.utilk.android;

import android.content.Context;

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
        UtilKLaunchActivity.startInstall(context, strPathNameApk);
    }
}
