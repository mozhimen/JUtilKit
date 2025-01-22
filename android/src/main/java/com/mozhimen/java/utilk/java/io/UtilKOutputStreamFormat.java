package com.mozhimen.java.utilk.java.io;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/**
 * @ClassName UtilKOutputStream
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKOutputStreamFormat {
    public static BufferedOutputStream outputStream2bufferedOutputStream(OutputStream outputStream) {
        return UtilKBufferedOutputStream.get(outputStream);
    }
}
