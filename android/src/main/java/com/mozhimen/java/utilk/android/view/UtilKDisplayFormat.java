package com.mozhimen.java.utilk.android.view;

import com.mozhimen.java.
utilk.android.util.UtilKDisplayMetrics;

/**
 * @ClassName UtilKDisplayFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:30
 * @Version 1.0
 */
public class UtilKDisplayFormat {
    public static float dp2px(/*@FloatRange(from = 0.0)*/ Float dp) {
        return dp * UtilKDisplayMetrics.getDensity_ofSys();
    }
}
