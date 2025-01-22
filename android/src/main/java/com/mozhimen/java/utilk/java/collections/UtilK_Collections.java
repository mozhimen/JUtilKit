package com.mozhimen.java.utilk.java.collections;

import com.mozhimen.java.
elemk.java.functions.Function1;

import java.util.Collection;
import java.util.Iterator;


/**
 * @ClassName UtilK_Collections
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
public class UtilK_Collections {
    public static <T> boolean any(Iterable<T> iterable, Function1<T, Boolean> predicate) {
        if (iterable instanceof Collection && ((Collection<T>) iterable).isEmpty()) return false;
        for (T t : iterable) {
            if (predicate.invoke(t)) return true;
        }
        return false;
    }
}
