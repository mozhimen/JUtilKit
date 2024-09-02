package com.mozhimen.java.utilk.android.graphics;

import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

import com.mozhimen.java.utilk.android.view.UtilKDisplayFormat;

/**
 * @ClassName UtilKStateListDrawable
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:57
 * @Version 1.0
 */
public class UtilKStateListDrawable {
    public static StateListDrawable get(int intColorNormal, int intColorPressed, int intColorStrokeNormal, int intColorStrokePressed, float radius, float stroke) {
        GradientDrawable drawableNormal = new GradientDrawable();
        drawableNormal.setCornerRadius(UtilKDisplayFormat.dp2px(radius));
        drawableNormal.setColor(intColorNormal);
        drawableNormal.setStroke((int) UtilKDisplayFormat.dp2px(stroke), intColorStrokeNormal);

        GradientDrawable drawablePressed = new GradientDrawable();
        drawablePressed.setCornerRadius(UtilKDisplayFormat.dp2px(radius));
        drawablePressed.setColor(intColorPressed);
        drawablePressed.setStroke((int) UtilKDisplayFormat.dp2px(stroke), intColorStrokePressed);

        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed}, drawablePressed);
        stateListDrawable.addState(new int[]{-android.R.attr.state_pressed}, drawableNormal);
        return stateListDrawable;
    }
}
