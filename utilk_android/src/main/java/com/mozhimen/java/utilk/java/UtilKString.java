package com.mozhimen.java.utilk.java;

import java.nio.charset.Charset;

/**
 * @ClassName UtilKString
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilKString {
    public static String get(byte[] bytes, Charset charset) {
        return new String(bytes, charset);
    }

    public static String get(byte[] bytes, int offset, int length) {
        return new String(bytes, offset, length);
    }
}
