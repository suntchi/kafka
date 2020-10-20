package com.stc.kafka.design.singleton.repeat;

import java.util.Objects;

/**
 * <p>
 * 懒汉模式
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/29
 */
public class LazySynchronized {
    private static LazySynchronized lazySynchronized;

    private LazySynchronized() {
    }

    public static synchronized LazySynchronized  getInstance(){
        if(Objects.isNull(lazySynchronized)){
            lazySynchronized = new LazySynchronized();
        }
        return lazySynchronized;
    }
}
