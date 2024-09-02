package com.mozhimen.java.utilk.java.net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @ClassName UtilKURL
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/8/1
 * @Version 1.0
 */
public class UtilKURL {
    public static URL get(String strUrl) throws MalformedURLException {
        return new URL(strUrl);
    }
}
