package com.mozhimen.java.elemk.java.functions;

/**
 * @ClassName Function0
 * @Description TODO
 * @Author mozhimen
 * @Date 2024/11/21
 * @Version 1.0
 */
/** A function that takes 0 arguments. */
public interface Function0<R> extends Function<R> {
    /** Invokes the function. */
    public R invoke();
}