package com.stc.kafka.locks.synchronizedlock;

import lombok.SneakyThrows;

import java.util.concurrent.CountDownLatch;

/**
 * <p>
 * 修饰代码快
 * </p>
 *
 * @author Tianchi Sun
 * @since 2020/9/29
 */
public class Block implements Runnable{
        private static int count;
        private CountDownLatch countDownLatch;

        public Block(CountDownLatch countDownLatch) {
            count = 0;
            this.countDownLatch = countDownLatch;
        }

        @SneakyThrows
        @Override
        public void run() {
            synchronized (this){
                for (int i = 0; i < 5; i++) {
                    System.out.println(Thread.currentThread().getName() + ":" + (count++));
                    Thread.sleep(100L);
                }
                countDownLatch.countDown();
            }
        }

        public int getCount(){
            return count;
        }
    }

