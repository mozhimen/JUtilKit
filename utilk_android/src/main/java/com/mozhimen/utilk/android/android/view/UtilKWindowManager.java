package com.mozhimen.utilk.android.android.view;

import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

import com.mozhimen.utilk.android.android.content.UtilKContext;

/**
 * @ClassName UtilKWindowManager
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 14:26
 * @Version 1.0
 */
public class UtilKWindowManager {
    public static WindowManager get(Context context) {
        return UtilKContext.getWindowManager(context);
    }

    public static Display getDefaultDisplay(Context context){
        return get(context).getDefaultDisplay();
    }
}
