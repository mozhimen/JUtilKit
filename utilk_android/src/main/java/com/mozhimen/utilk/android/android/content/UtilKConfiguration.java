package com.mozhimen.utilk.android.android.content;

import android.content.res.Configuration;

/**
 * @ClassName UtilKConfiguration
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:15
 * @Version 1.0
 */
public class UtilKConfiguration {
    private static final String TAG = "UtilKConfiguration>>>>>";

    public static Configuration get() {
        return UtilKResources.getConfiguration_ofSys();
    }

    public static int getOrientation() {
        return get().orientation;
    }

    public static Boolean isOrientationPortrait() {
        return getOrientation() == Configuration.ORIENTATION_PORTRAIT;
    }
}
