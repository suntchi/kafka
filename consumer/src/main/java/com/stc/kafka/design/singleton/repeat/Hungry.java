package com.stc.kafka.design.singleton.repeat;
/**
 * <p>
 * 饿汉模式
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/27
 */
public class Hungry {

    private static Hungry hungry = new Hungry();

    private Hungry() {
    }

    public static Hungry getHungry(){
        return hungry;
    }
}
