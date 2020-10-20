package com.stc.kafka.design.singleton;
/**
 * <p>
 * 拉汉模式，双重检查锁
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/27
 */
public class LazyVolatile {

    private volatile static LazyVolatile lazyVolatile= null;

    private LazyVolatile() {
    }

    public static LazyVolatile getInstance(){
        if(lazyVolatile == null){
            synchronized (LazyVolatile.class){
                if(lazyVolatile == null){
                    lazyVolatile = new LazyVolatile();
                }
            }
        }
        return lazyVolatile;
    }
}
