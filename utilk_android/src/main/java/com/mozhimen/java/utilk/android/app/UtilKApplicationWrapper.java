package com.mozhimen.java.utilk.android.app;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

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

    private static class ApplicationUtilHolder {
        private static final UtilKApplicationWrapper INSTANCE = new UtilKApplicationWrapper();
    }

    public static UtilKApplicationWrapper getInstance() {
        return ApplicationUtilHolder.INSTANCE;
    }

    ////////////////////////////////////////////////////////////

    private Application _application;

    /**
     * 获取全局上下文
     */
    @SuppressLint("PrivateApi")
    public Application get() {
        if (_application == null) {
            try {
                _application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication").invoke(null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return _application;
    }

    public Context getApplicationContext() {
        return get().getApplicationContext();
    }
}
