package com.fly.test.thread.lock;

import org.junit.Test;

public class SynchronizedTest implements Runnable {

    public synchronized void get(){
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
    }

    public synchronized void set(){
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }

    @Test
    public void testSynchronizedReentrant() {
        SynchronizedTest test = new SynchronizedTest();

        for(int i = 0; i < 5; i++) {
            new Thread(test, "thread-" + i).start();
        }
    }

}
