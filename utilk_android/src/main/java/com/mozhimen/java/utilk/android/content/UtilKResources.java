package com.mozhimen.java.utilk.android.content;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/**
 * @ClassName UtilKResources
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:14
 * @Version 1.0
 */
public class UtilKResources {
    public static Resources get_ofSys() {
        return Resources.getSystem();
    }

    ////////////////////////////////////////////////////////////////////////////

    public static DisplayMetrics getDisplayMetrics_ofSys() {
        return get_ofSys().getDisplayMetrics();
    }

    public static Configuration getConfiguration_ofSys() {
        return get_ofSys().getConfiguration();
    }
}
