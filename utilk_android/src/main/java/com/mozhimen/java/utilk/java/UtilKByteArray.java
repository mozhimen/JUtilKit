package com.mozhimen.java.utilk.java;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName UtilKByteArray
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKByteArray {
    public static byte[] get(int size) {
        return new byte[size];
    }

    public static byte[] get(InputStream inputStream) throws IOException {
        return new byte[inputStream.available()];
    }
}
