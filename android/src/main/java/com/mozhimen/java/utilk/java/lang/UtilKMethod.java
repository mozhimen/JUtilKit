package com.mozhimen.java.utilk.java.lang;

import java.lang.reflect.Method;
import java.util.Arrays;

/**
 * @ClassName UtilKMethod
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/6 18:21
 * @Version 1.0
 */
public class UtilKMethod {
    public static Method get(Object obj, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        return get(obj.getClass(), methodName, parameterTypes);
    }

    public static Method get(Class<?> clazz, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        for (Class<?> tempClazz = clazz; tempClazz != null; tempClazz = tempClazz.getSuperclass()) {
            try {
                Method method = tempClazz.getDeclaredMethod(methodName, parameterTypes);
                if (!method.isAccessible()) {
                    method.setAccessible(true);
                }
                return method;
            } catch (NoSuchMethodException e) {
                // ignore and search next
            }
        }
        throw new NoSuchMethodException("Method " + methodName + " with parameters " + Arrays.asList(parameterTypes) + " not found in " + clazz);
    }
}
