package com.mozhimen.java.utilk.bases;

import android.content.Context;

import com.mozhimen.java.utilk.android.app.UtilKApplicationWrapper;
import com.mozhimen.java.utilk.commons.IUtilK;

/**
 * @ClassName BaseUtilK
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public abstract class BaseUtilK implements IUtilK {
    protected static Context getContext(){
        return UtilKApplicationWrapper.getInstance().getApplicationContext();
    }
}
