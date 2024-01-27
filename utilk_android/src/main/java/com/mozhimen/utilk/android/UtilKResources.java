package com.mozhimen.utilk.android;

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
    public static Resources getSystem() {
        return Resources.getSystem();
    }

    public static DisplayMetrics getDisplayMetrics() {
        return getSystem().getDisplayMetrics();
    }

    public static Configuration getConfiguration() {
        return getSystem().getConfiguration();
    }
}
