package com.mozhimen.java.utilk.android.content;

import android.content.Context;

import java.io.File;

/**
 * @ClassName UtilKContextDir
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKContextDir {
    /**
     * 无需申请权限
     * 内部使用，外部程序无法访问。卸载应用时删除。
     */
    public static class Internal{
        /**
         * 系统空间不足时可能会删除
         */
        public static File getCacheDir (Context context){
            return UtilKContext.getCacheDir(context);
        }

        public static File getFilesDir (Context context) {
            return UtilKContext.getFilesDir(context);
        }
    }
}