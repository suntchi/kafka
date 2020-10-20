package com.stc.kafka.locks.reentrantlock;
/**
 * <p>
 * 父类
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/10/9
 */
public class Animal {
    protected String eatNum;

    protected void eat(){
        System.out.println("父类eat");
    }

    public Animal(String eatNum) {
        this.eatNum = eatNum;
    }
}
