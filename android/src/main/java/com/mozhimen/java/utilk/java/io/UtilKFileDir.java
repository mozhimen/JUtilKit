package com.mozhimen.java.utilk.java.io;

import com.mozhimen.java.
utilk.android.content.UtilKContextDir;
import com.mozhimen.java.
utilk.bases.BaseUtilK;

import java.io.File;

/**
 * @ClassName UtilKFileDir
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKFileDir extends BaseUtilK {
    public static class Internal {
        public static File getFiles() {
            return UtilKContextDir.Internal.getFilesDir(getContext());
        }

        public static File getCache() {
            return UtilKContextDir.Internal.getCacheDir(getContext());
        }
    }
}
