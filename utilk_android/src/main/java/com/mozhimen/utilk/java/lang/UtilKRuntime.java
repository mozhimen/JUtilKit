package com.mozhimen.utilk.java.lang;

import java.io.IOException;

/**
 * @ClassName RuntimeUtil
 * @Description TODO
 * @Author Mozhimen & Kolin Zhao
 * @Date 2024/1/17 16:06
 * @Version 1.0
 */
public class UtilKRuntime {
    public static Runtime get() {
        return Runtime.getRuntime();
    }

    public static void chmod777(String path) {
        try {
            get().exec("chmod 777 " + UtilKStrFile.getStrFolderPath(path));
            get().exec("chmod 777 " + path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
