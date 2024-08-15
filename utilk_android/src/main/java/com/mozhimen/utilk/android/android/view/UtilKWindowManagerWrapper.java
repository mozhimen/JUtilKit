package com.mozhimen.utilk.android.android.view;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.WindowManager;

import com.mozhimen.utilk.android.commons.IUtilK;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UtilKWindowManagerWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/4
 * @Version 1.0
 */
public class UtilKWindowManagerWrapper implements IUtilK {

    private static Class<?> _clazz;

    @SuppressLint("PrivateApi")
    public static Class<?> getWindowManagerClazz() throws ClassNotFoundException {
        if (_clazz == null) {
            _clazz = Class.forName("android.view.WindowManagerGlobal");
        }
        return _clazz;
    }

    private static Object _instance;

    public static Object getWindowManagerInstance() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ClassNotFoundException {
        if (_instance == null) {
            _instance = getWindowManagerClazz().getMethod("getInstance").invoke(null);
        }
        return _instance;
    }

    public static Field getViewsField() throws ClassNotFoundException, NoSuchFieldException {
        Field field = getWindowManagerClazz().getDeclaredField("mViews");
        field.setAccessible(true);
        return field;
    }

    public static Field getParamsField() throws ClassNotFoundException, NoSuchFieldException {
        Field field = getWindowManagerClazz().getDeclaredField("mParams");
        field.setAccessible(true);
        return field;
    }

    public static List<View> getViews() throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return (ArrayList<View>) getViewsField().get(getWindowManagerInstance());
    }

    public static List<WindowManager.LayoutParams> getParams() throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        return (ArrayList<WindowManager.LayoutParams>) getParamsField().get(getWindowManagerInstance());
    }
}