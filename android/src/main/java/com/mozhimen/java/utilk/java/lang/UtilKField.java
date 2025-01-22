package com.mozhimen.java.utilk.java.lang;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName UtilKField
 * @Description TODO
 * @Author Mozhimen / Kolin Zhao
 * @Date 2024/10/6 18:08
 * @Version 1.0
 */
public class UtilKField {
    public static Field get(Object obj, String fieldName) throws NoSuchFieldException {
        return get(obj.getClass(), fieldName);
    }

    //仅能获取类本身的属性成员（包括私有、共有、保护）
    public static Field get(Class<?> clazz, String fieldName) throws NoSuchFieldException {
        for (Class<?> tempClazz = clazz; tempClazz != null; tempClazz = tempClazz.getSuperclass()) {
            try {
                Field field = tempClazz.getDeclaredField(fieldName);
                if (!field.isAccessible()) field.setAccessible(true);
                return field;
            } catch (NoSuchFieldException e) {
                // ignore and search next
            }
        }
        throw new NoSuchFieldException("Field " + fieldName + " not found in " + clazz);
    }

    //////////////////////////////////////////////////////////////////////////

    public static int getInt(Object obj, String fieldName) throws NoSuchFieldException, IllegalAccessException {
        return get(obj, fieldName).getInt(obj);
    }

    //////////////////////////////////////////////////////////////////////////

    //获取类及其基类所有的field
    public static List<Field> getAll(Object obj) {
        return getAll(obj.getClass());
    }

    //获取类及其基类所有的field
    public static List<Field> getAll(Class<?> clazz) {
        ArrayList<Field> fields = new ArrayList<>(Arrays.asList(clazz.getDeclaredFields()));
        Class<?> superClass = clazz.getSuperclass();
        while (superClass != null) {
            Field[] superFields = superClass.getDeclaredFields();
            fields.addAll(Arrays.asList(superFields));
            superClass = superClass.getSuperclass();
        }
        return fields;
    }
}
