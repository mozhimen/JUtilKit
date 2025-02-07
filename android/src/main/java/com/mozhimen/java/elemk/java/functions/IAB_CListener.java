package com.mozhimen.java.elemk.java.functions;

/**
 * @ClassName IAB_CListener
 * @Description TODO
 * @Author mozhimen
 * @Date 2025/2/6
 * @Version 1.0
 */
public interface IAB_CListener<A, B, C> {
    public C invoke(A a, B b);
}
