package com.mozhimen.utilk.android.android.util;

import android.util.DisplayMetrics;

import com.mozhimen.utilk.android.android.content.UtilKResources;

/**
 * @ClassName UtilKDisplayMetrics
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:15
 * @Version 1.0
 */
public class UtilKDisplayMetrics {
    public static DisplayMetrics get_ofSys() {
        return UtilKResources.getDisplayMetrics_ofSys();
    }

    //////////////////////////////////////////////////////////////////////

    public static float getDensity_ofSys() {
        return get_ofSys().density;
    }

    public static int getWidthPixels_ofSys() {
        return get_ofSys().widthPixels;
    }

    public static int getHeightPixels_ofSys() {
        return get_ofSys().heightPixels;
    }

    public static int getRelativeWidth_ofSys(boolean isOrientationPortrait) {
        int a = getWidthPixels_ofSys();
        int b = getHeightPixels_ofSys();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int width;
        if (isOrientationPortrait) {
            width = min;
        } else {
            width = max;
        }
        return width;
    }

    public static int getRelativeHeight_ofSys(boolean isOrientationPortrait) {
        int a = getWidthPixels_ofSys();
        int b = getHeightPixels_ofSys();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int height;
        if (isOrientationPortrait) {
            height = max;
        } else {
            height = min;
        }
        return height;
    }

    public static float getRatio_ofSys() {
        int a = getWidthPixels_ofSys();
        int b = getHeightPixels_ofSys();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return (float) max / (float) min;
    }
}
