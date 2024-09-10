package com.mozhimen.java.utilk.java;

/**
 * @ClassName UtilKStrPackage
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/9/10
 * @Version 1.0
 */
public class UtilKStrPackage {
    public static Class<?> strPackage2clazz(String strPackage) throws ClassNotFoundException {
        return Class.forName(strPackage);
    }
}
