package com.stc.kafka.design.singleton;
/**
 * <p>
 * 懒汉模式,使用锁
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/27
 */
public class LazySynchronized {
    private static LazySynchronized lazySynchronized;

    private LazySynchronized() {
    }

    public static synchronized LazySynchronized  getInstance(){

        if(lazySynchronized == null){
            lazySynchronized = new  LazySynchronized();
        }

        return lazySynchronized;
    }
}
