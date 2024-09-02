package com.mozhimen.java.utilk.android.util;

import android.util.DisplayMetrics;

import com.mozhimen.java.elemk.android.android.util.cons.CTypedValue;

/**
 * @ClassName UtilKDisplayMetricsWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKDisplayMetricsWrapper {
    public static float dp2px(/*@FloatRange(from = 0.0)*/ float dp) {
        return dp2px_ofSys(dp);
    }

    public static float dp2px_ofSys(/*@FloatRange(from = 0.0)*/ float dp) {
        return dp2px(dp, UtilKDisplayMetrics.get_ofSys());
    }

    public static float  dp2px(/*@FloatRange(from = 0.0)*/float dp, DisplayMetrics displayMetrics) {
        return UtilKTypedValue.applyDimension(CTypedValue.COMPLEX_UNIT_DIP, dp, displayMetrics);
    }
}
