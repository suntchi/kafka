package com.stc.kafka.design.singleton.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * <p>
 * 生产者和消费者模型
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/10/29
 */
public class ProducerAndConsumer {
    private final int MAX_COUNT = 10;

    private volatile boolean flag = true;

    private static Integer atomicInteger = 0;

    private static final List<Integer> POOL = new ArrayList<>();


    public void producer() {
         while (flag){
             //每隔100毫秒生产一个东西
             try {
                 Thread.sleep(100L);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }

             synchronized (POOL){
                 //判断如果池子慢了，就停止生产
                 while (POOL.size() == MAX_COUNT){
                     //停止生产
                     System.out.println("池子已满，停止生产");
                     try {
                         POOL.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }

                 Integer before = atomicInteger;
                 //生产
                 POOL.add(atomicInteger ++);

                 System.out.println("生产：" + before + "池子容量：" + POOL.size());

                 //唤醒其他线程
                 POOL.notify();
             }


         }
    }

    public void consumer(){
         while (flag){
             //每隔100毫秒消费一个东西
             try {
                 Thread.sleep(100L);
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
             synchronized (POOL){
                 //判断是否为0，如果为0，则不消费
                 while (POOL.size() == 0){
                     //停止消费
                     try {
                         System.out.println("库存为0，停止消费");
                         POOL.wait();
                     } catch (InterruptedException e) {
                         e.printStackTrace();
                     }
                 }

                 //消费
                 Integer integer = POOL.get(0);

                 POOL.remove(0);
                 System.out.println("消费：" + integer + "池子容量：" + POOL.size());

                 POOL.notify();
             }
         }
    }

    public void stop(){
        flag = false;
    }


    public static void main(String[] args) {
        new Thread(() -> new ProducerAndConsumer().producer(),"aaa").start();
        new Thread(() -> new ProducerAndConsumer().producer(),"ccc").start();
        new Thread(() -> new ProducerAndConsumer().consumer(),"bbb").start();
    }

}
