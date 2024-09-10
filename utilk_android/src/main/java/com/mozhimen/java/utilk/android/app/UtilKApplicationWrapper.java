package com.mozhimen.java.utilk.android.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.mozhimen.java.utilk.java.UtilKStrPackage;

/**
 * @ClassName ApplicationUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/5/7
 * @Version 1.0
 */
public class UtilKApplicationWrapper {

    private UtilKApplicationWrapper() {
    }

    public static UtilKApplicationWrapper getInstance() {
        return INSTANCE.holder;
    }

    private Application _application;

    ////////////////////////////////////////////////////////////


    /**
     * 获取全局上下文
     */
    @SuppressLint("PrivateApi")
    public Application get() {
        if (_application == null) {
            try {
                _application = (Application) UtilKStrPackage.strPackage2clazz("android.app.AppGlobals").getMethod("getInitialApplication").invoke(null);
                if (_application == null) {
                    throw new IllegalStateException("Static initialization of Applications must be on main thread.");
                }
            } catch (Exception e) {
                try {
                    _application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
                } catch (Exception e1) {
                    e1.printStackTrace();
                }
            }
        }
        return _application;
    }

    public Context getApplicationContext() {
        return get().getApplicationContext();
    }

    ////////////////////////////////////////////////////////////

    private static class INSTANCE {
        private static final UtilKApplicationWrapper holder = new UtilKApplicationWrapper();
    }
}
