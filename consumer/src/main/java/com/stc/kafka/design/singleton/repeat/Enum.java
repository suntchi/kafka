package com.stc.kafka.design.singleton.repeat;
/**
 * <p>
 * 枚举单例
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/29
 */
public enum Enum {
    INSTANCE;

    public void doSomeThing(){
        System.out.println("do something");
    }

    public static void main(String[] args) {
        Enum.INSTANCE.doSomeThing();
    }
}
