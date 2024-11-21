package com.mozhimen.java.elemk.java.functions;

/**
 * @ClassName Function2
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */

/**
 * A function that takes 2 arguments.
 */
public interface Function2<P1, P2, R> extends Function<R> {
    /**
     * Invokes the function with the specified arguments.
     */
    public R invoke(P1 p1, P2 p2);
}