package com.stc.kafka.design.singleton;

import lombok.Data;

/**
 * <p>
 * 饿汉模式,缺点：一上来就创建，如果没有一直没有用到，就是浪费资源
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/27
 */
@Data
public class Hungry {

    private static Hungry hungry = new Hungry();

    private Hungry() {
    }

    public static Hungry getInstance(){
        return hungry;
    }

}
