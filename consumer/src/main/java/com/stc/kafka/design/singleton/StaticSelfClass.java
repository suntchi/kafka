package com.stc.kafka.design.singleton;
/**
 * <p>
 * 静态内部类方式
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/27
 */
public class StaticSelfClass {
    private static class StaticSelfClassInstance{
        private static final StaticSelfClass STATIC_SELF_CLASS = new StaticSelfClass();
    }

    private StaticSelfClass() {
    }

    public static StaticSelfClass getInstance(){
        
        return StaticSelfClassInstance.STATIC_SELF_CLASS;
    }
}
