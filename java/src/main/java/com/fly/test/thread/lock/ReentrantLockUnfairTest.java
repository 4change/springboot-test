package com.fly.test.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockUnfairTest implements Runnable {

    private ReentrantLock reentrantLock = new ReentrantLock();

    public void get(){
        reentrantLock.lock();
        System.out.println("2 enter thread name-->" + Thread.currentThread().getName());
        System.out.println("3 get thread name-->" + Thread.currentThread().getName());
        set();
        System.out.println("5 leave run thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    public void set(){
        reentrantLock.lock();
        System.out.println("4 set thread name-->" + Thread.currentThread().getName());
        reentrantLock.unlock();
    }

    @Override
    public void run() {
        System.out.println("1 run thread name-->" + Thread.currentThread().getName());
        get();
    }

    public static void main(String[] args){
        ReentrantLockUnfairTest test = new ReentrantLockUnfairTest();
        for(int i = 0; i < 5; i++){
            new Thread(test, "thread-" + i).start();
        }
    }

}
