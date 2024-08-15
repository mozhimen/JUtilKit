package com.mozhimen.utilk.android.java.lang;

import com.mozhimen.utilk.android.java.UtilKStrFile;

import java.io.IOException;

/**
 * @ClassName UtilKRuntimeWrapper
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKRuntimeWrapper {
    public static void exec_chmod_777(String path) {
        try {
            UtilKRuntime.get().exec("chmod 777 " + UtilKStrFile.getStrFolderPath(path));
            UtilKRuntime.get().exec("chmod 777 " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
