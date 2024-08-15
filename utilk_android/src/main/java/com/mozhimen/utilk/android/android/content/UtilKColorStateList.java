package com.mozhimen.utilk.android.android.content;

import android.content.res.ColorStateList;

/**
 * @ClassName UtilKColorStateList
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:13
 * @Version 1.0
 */
public class UtilKColorStateList {
    public static ColorStateList get(int normal, int pressed) {
        int[][] states = new int[2][];//状态
        states[0] = new int[]{android.R.attr.state_pressed};//按下
        states[1] = new int[]{};//默认
        int[] colors = new int[]{pressed, normal};//状态对应颜色值（按下，默认）
        return new ColorStateList(states, colors);
    }
}
