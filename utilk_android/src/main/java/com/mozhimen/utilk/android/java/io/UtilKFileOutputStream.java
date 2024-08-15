package com.mozhimen.utilk.android.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName UtilKFileOutputStream
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/15
 * @Version 1.0
 */
public class UtilKFileOutputStream {
    public static FileOutputStream get(File file) throws FileNotFoundException {
        return get(file, false);
    }

    public static FileOutputStream get(File file, boolean isAppend) throws FileNotFoundException {
        return new FileOutputStream(file, isAppend);
    }
}
