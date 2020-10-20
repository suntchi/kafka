package com.stc.kafka.locks.reentrantlock;
/**
 * <p>
 * 猫
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/10/9
 */
public class Cat extends Animal implements AnimalIntercace{
    private String name;

    private void catEat(){

    }

    public Cat(String eatNum, String name) {
        super(eatNum);
        this.name = name;
    }

    @Override
    public void sout() {
        System.out.println(A);
    }
}
