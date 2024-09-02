package com.mozhimen.java.utilk.android.view;

import android.content.Context;
import android.view.Display;
import android.view.Surface;

import com.mozhimen.java.elemk.android.android.content.cons.CActivityInfo;

/**
 * @ClassName UtilKDisplay
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:14
 * @Version 1.0
 */
public class UtilKDisplay {
    public static Display get_ofDef(Context context) {
        return UtilKWindowManager.getDefaultDisplay(context);
    }

    ///////////////////////////////////////////////////////////

    public static int getRotation_ofDef(Context context) {
        return get_ofDef(context).getRotation();
    }

    public static int getOrientation_ofDef(Context context) {
        int rotation = UtilKDisplay.getRotation_ofDef(context);
        int orientation;
        switch (rotation) {
            case Surface.ROTATION_90:

            case Surface.ROTATION_270: {
                orientation = CActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                break;
            }

            default: {
                orientation = CActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                break;
            }
        }
        return orientation;
    }

    public static boolean isOrientationPortrait_ofDef(Context context) {
        return getOrientation_ofDef(context) == CActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }
}
