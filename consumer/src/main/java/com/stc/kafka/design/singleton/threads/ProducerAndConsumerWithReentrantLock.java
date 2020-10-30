package com.stc.kafka.design.singleton.threads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
/**
 * <p>
 * TODO
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/10/29
 */
public class ProducerAndConsumerWithReentrantLock {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private void increment(){
        lock.lock();
        try {
            //如果库存不为0，则不生产
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }


    }

    private void decrement(){

    }
}
