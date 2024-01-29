package com.mozhimen.utilk.java.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName UtilKFileFormat
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/1/27 15:33
 * @Version 1.0
 */
public class UtilKFileFormat {
    public static FileOutputStream file2fileOutputStream(File file, boolean isAppend) throws FileNotFoundException {
        return new FileOutputStream(file, isAppend);
    }
}
