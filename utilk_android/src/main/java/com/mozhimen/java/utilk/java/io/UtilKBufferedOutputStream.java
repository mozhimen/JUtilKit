package com.mozhimen.java.utilk.java.io;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/**
 * @ClassName UtilKBufferedOutputStream
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKBufferedOutputStream {
    public static BufferedOutputStream get(OutputStream outputStream) {
        return new BufferedOutputStream(outputStream);
    }
}
