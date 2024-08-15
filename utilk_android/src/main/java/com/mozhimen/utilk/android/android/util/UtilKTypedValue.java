package com.mozhimen.utilk.android.android.util;

import android.util.DisplayMetrics;
import android.util.TypedValue;

/**
 * @ClassName UtilKTypedValue
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKTypedValue {
    public static float applyDimension(/*@TypedValueCompat.ComplexDimensionUnit*/ int unit, float value, DisplayMetrics metrics) {
        return TypedValue.applyDimension(unit, value, metrics);
    }
}
