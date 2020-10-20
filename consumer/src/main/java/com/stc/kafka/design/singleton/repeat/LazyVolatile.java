package com.stc.kafka.design.singleton.repeat;

import java.util.Objects;

/**
 * <p>
 * 懒汉模式volatile
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/29
 */
public class LazyVolatile {
    private volatile static LazyVolatile lazyVolatile;

    private LazyVolatile() {
    }

    public static LazyVolatile getInstance(){
        if(Objects.isNull(lazyVolatile)){
            synchronized (LazyVolatile.class){
                if(Objects.isNull(lazyVolatile)){
                    lazyVolatile = new LazyVolatile();
                }
            }
        }
        return lazyVolatile;
    }
}
