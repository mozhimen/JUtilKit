package com.mozhimen.utilk.android.view;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.util.Log;
import android.view.Display;
import android.view.Surface;

/**
 * @ClassName UtilKDisplay
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:14
 * @Version 1.0
 */
public class UtilKDisplay {
    private static final String TAG = "UtilKDisplay>>>>>";

    public static Display getDefault(Context context) {
        return UtilKWindowManager.getDefaultDisplay(context);
    }

    public static int getDefaultRotation(Context context) {
        return getDefault(context).getRotation();
    }

    public static int getOrientation(Context context) {
        int rotation = UtilKDisplay.getDefaultRotation(context);
        int orientation;
        switch (rotation) {
            case Surface.ROTATION_90: {
                orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                break;
            }

            case Surface.ROTATION_270: {
                orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
                break;
            }

            default: {
                orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
                break;
            }
        }
        return orientation;
    }

    public static boolean isOrientationPortrait(Context context) {
        boolean isOrientationPortrait = getOrientation(context) == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        Log.d(TAG, "isOrientationPortrait: " + isOrientationPortrait);
        return isOrientationPortrait;
    }
}
