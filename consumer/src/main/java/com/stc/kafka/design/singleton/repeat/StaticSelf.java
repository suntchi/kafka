package com.stc.kafka.design.singleton.repeat;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 静态内部类
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/29
 */
public class StaticSelf {



    public static StaticSelf getInstance(){
        return StaticSelfInit.STATIC_SELF;
    }

    private StaticSelf() {
    }

    private static class  StaticSelfInit{
        private static final StaticSelf STATIC_SELF = new StaticSelf();
    }
}
