package com.mozhimen.java.utilk.java.lang;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @ClassName UtilKClass
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/6 19:19
 * @Version 1.0
 */
public class UtilKClass {
    public static boolean isInstanceOf(Object obj, Class<?> genericClass) {
        Type type = obj.getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) type;
            Type rawType = parameterizedType.getRawType();
            return rawType.equals(genericClass);
        }
        return false;
    }
}
