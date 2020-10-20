package com.stc.kafka.design.singleton;

/**
 * <p>
 * 枚举类，本质和内部静态类没有什么区别
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/27
 */
public enum Enum {
    /**
     * 枚举类本身就是单例
     */
    INSTANCE;

    public void doSomeThing() {
        System.out.println("枚举单例模式");
    }

    public static void main(String[] args) {
        Enum.INSTANCE.doSomeThing();
    }


}
