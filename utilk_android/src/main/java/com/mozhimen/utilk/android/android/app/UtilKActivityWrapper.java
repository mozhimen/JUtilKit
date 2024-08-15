package com.mozhimen.utilk.android.android.app;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.view.View;
import android.view.WindowManager;

import com.mozhimen.utilk.android.android.os.UtilKBuildVersion;
import com.mozhimen.utilk.android.android.view.UtilKWindowManagerWrapper;
import com.mozhimen.utilk.android.commons.IUtilK;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName UtilKActivityWrapper
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/6/4
 * @Version 1.0
 */
public class UtilKActivityWrapper implements IUtilK {

    /**
     * 判断这个意图的 Activity 是否存在
     */
    @SuppressLint("NewApi")
    @SuppressWarnings("BooleanMethodIsAlwaysInverted")
    static boolean hasActivity_ofIntent( Context context,  Intent intent) {
        if (intent == null) {
            return false;
        }
        // 这里为什么不用 Intent.resolveActivity(intent) != null 来判断呢？
        // 这是因为在 OPPO R7 Plus （Android 5.0）会出现误判，明明没有这个 Activity，却返回了 ComponentName 对象
        PackageManager packageManager = context.getPackageManager();
        if (UtilKBuildVersion.isAfterV_33_13_TIRAMISU()) {
            return !packageManager.queryIntentActivities(intent,
                    PackageManager.ResolveInfoFlags.of(PackageManager.MATCH_DEFAULT_ONLY)).isEmpty();
        }
        return !packageManager.queryIntentActivities(intent, PackageManager.MATCH_DEFAULT_ONLY).isEmpty();
    }

    public static boolean hasFloatWindow_ofToken(Activity activity) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // 获取目标 Activity 的 decorView
        View targetDecorView = activity.getWindow().getDecorView();
        // 获取目标 Activity 的 子窗口的 token
        IBinder targetSubToken = targetDecorView.getWindowToken();

        //  拿到 mView 集合，找到目标 Activity 所在的 index 位置
        List<View> mView = UtilKWindowManagerWrapper.getViews();
        int targetIndex = -1;
        for (int i = 0; i < mView.size(); i++) {
            if (mView.get(i) == targetDecorView) {
                targetIndex = i;
                break;
            }
        }

        // 获取 mParams 集合
        List<WindowManager.LayoutParams> mParams = UtilKWindowManagerWrapper.getParams();
        // 根据目标 index 从 mParams 集合中找到目标 token
        IBinder targetToken;
        if(!mParams.isEmpty()&&targetIndex>=0&&targetIndex<mParams.size()) {
            targetToken = mParams.get(targetIndex).token;
        }else{
            return false;
        }
        // 遍历判断时，目标 Activity 自己不能包括,所以 size 需要大于 1
        return mParams.stream().map(it -> it.token).filter(it -> it == targetSubToken || it == null || it == targetToken).count() > 1;
    }

    public static List<View> getFloatWindowViewByToken(Activity activity) throws NoSuchFieldException, ClassNotFoundException, InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        // 获取目标 Activity 的 decorView
        View targetDecorView = activity.getWindow().getDecorView();
        // 获取目标 Activity 的 子窗口的 token
        IBinder targetSubToken = targetDecorView.getWindowToken();


        //  拿到 mView 集合，找到目标 Activity 所在的 index 位置
        List<View> mViews = UtilKWindowManagerWrapper.getViews();
        int targetIndex = -1;
        for (int i = 0; i < mViews.size(); i++) {
            if (mViews.get(i) == targetDecorView) {
                targetIndex = i;
                break;
            }
        }

        // 获取 mParams 集合
        List<WindowManager.LayoutParams> mParams = UtilKWindowManagerWrapper.getParams();
        // 根据目标 index 从 mParams 集合中找到目标 token
        IBinder targetToken = mParams.get(targetIndex).token;

        ArrayList<View> floatView = new ArrayList<>();

        for (int i = 0; i < mParams.size(); i++) {
            IBinder token = mParams.get(i).token;
            // Activity 自身不参与
            if (i != targetIndex) {
                if (token == targetSubToken || token == null || token == targetToken) {
                    // 根据 index 拿到 mView 中的 View
                    floatView.add(mViews.get(i));
                }
            }
        }
        return floatView;
    }
}
