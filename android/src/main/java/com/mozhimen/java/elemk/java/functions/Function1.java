package com.mozhimen.java.elemk.java.functions;

/**
 * @ClassName Function1
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */

/**
 * A function that takes 1 argument.
 */
public interface Function1<P1, R> extends Function<R> {
    /**
     * Invokes the function with the specified argument.
     */
    public R invoke(P1 p1);
}