package com.stc.kafka.design.singleton.threads;

public class SynchronizedTest {
    public void test1() {
        synchronized (this) {
            System.out.println("test1");
            try {
                Thread.sleep(3000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void test2() {
        synchronized (this) {
            System.out.println("test2");
        }
    }

    public static synchronized void test3() {
        System.out.println("test3");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void test4() {
        System.out.println("test4");
    }

    public static void main(String[] args) {
//        run3();
//        run4();
//        run5();
//        run6();
    }

    private static void run1() {
        //同一个对象相互阻塞
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        new Thread(() -> synchronizedTest1.test1()).start();
        new Thread(() -> synchronizedTest1.test2()).start();
    }

    private static void run2() {
        //不同对象不阻塞
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        SynchronizedTest synchronizedTest2 = new SynchronizedTest();
        new Thread(() -> synchronizedTest1.test1()).start();
        new Thread(() -> synchronizedTest2.test2()).start();
    }

    private static void run3() {
        //类方法和对象方法不阻塞
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        new Thread(() -> synchronizedTest1.test1()).start();
        new Thread(() -> SynchronizedTest.test3()).start();
    }

    private static void run4() {
        //对象和没有synchronized的方法不阻塞
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        SynchronizedTest synchronizedTest2 = new SynchronizedTest();
        new Thread(() -> synchronizedTest1.test1()).start();
        new Thread(() -> synchronizedTest2.test4()).start();
    }

    private static void run5() {
        //类和没有synchronized的方法不阻塞
        SynchronizedTest synchronizedTest1 = new SynchronizedTest();
        new Thread(() -> SynchronizedTest.test3()).start();
        new Thread(() -> synchronizedTest1.test4()).start();
    }

    private static void run6() {
        //两个类方法阻塞
        new Thread(() -> SynchronizedTest.test3()).start();
        new Thread(() -> SynchronizedTest.test3()).start();
    }


}
