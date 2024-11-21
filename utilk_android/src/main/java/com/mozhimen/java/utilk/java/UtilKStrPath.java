package com.mozhimen.java.utilk.java;

import com.mozhimen.java.
utilk.java.io.UtilKFileDir;

/**
 * @ClassName UtilKStrPath
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKStrPath {
    public static class Absolute {
        public static class Internal {
            public static String getFiles() {
                return UtilKFileDir.Internal.getFiles().getAbsolutePath();
            }

            public static String getCache() {
                return UtilKFileDir.Internal.getCache().getAbsolutePath();
            }
        }
    }
}
