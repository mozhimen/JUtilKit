package com.mozhimen.utilk.android.android.content;

import android.content.res.Configuration;

import com.mozhimen.utilk.android.commons.IUtilK;

/**
 * @ClassName UtilKConfiguration
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:15
 * @Version 1.0
 */
public class UtilKConfiguration implements IUtilK {

    public static Configuration get_ofSys() {
        return UtilKResources.getConfiguration_ofSys();
    }

    //////////////////////////////////////////////////////////////////

    public static int getOrientation_ofSys() {
        return get_ofSys().orientation;
    }

    public static boolean isOrientationPortrait_ofSys() {
        return getOrientation_ofSys() == Configuration.ORIENTATION_PORTRAIT;
    }
}
