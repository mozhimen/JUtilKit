package com.mozhimen.utilk.android;

import android.annotation.SuppressLint;
import android.util.DisplayMetrics;
import android.util.Log;

/**
 * @ClassName UtilKDisplayMetrics
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:15
 * @Version 1.0
 */
public class UtilKDisplayMetrics {
    private static final String TAG = "UtilKDisplayMetrics>>>>>";

    public static DisplayMetrics get() {
        return UtilKResources.getDisplayMetrics();
    }

    public static float getDensity() {
        return get().density;
    }

    public static int getWidthPixels() {
        return get().widthPixels;
    }

    public static int getHeightPixels() {
        return get().heightPixels;
    }

    @SuppressLint("LongLogTag")
    public static int getRelativeWidth(boolean isOrientationPortrait) {
        int a = getWidthPixels();
        int b = getHeightPixels();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int width;
        if (isOrientationPortrait) {
            width = min;
        } else {
            width = max;
        }
        Log.d(TAG, "getRelativeWidth: " + width);
        return width;
    }

    @SuppressLint("LongLogTag")
    public static int getRelativeHeight(boolean isOrientationPortrait) {
        int a = getWidthPixels();
        int b = getHeightPixels();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        int height;
        if (isOrientationPortrait) {
            height = max;
        } else {
            height = min;
        }
        Log.d(TAG, "getRelativeHeight: " + height);
        return height;
    }

    public static float getScreenRatio() {
        int a = getWidthPixels();
        int b = getHeightPixels();
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        return (float) max / (float) min;
    }
}
