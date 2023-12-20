package com.fly.test.thread.create_thread;

public class ExtendsThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }
    }

    public static void main(String[] args) {
        ExtendsThread mThread1 = new ExtendsThread();
        ExtendsThread mThread2 = new ExtendsThread();
        ExtendsThread myThread3 = new ExtendsThread();
        mThread1.start();
        mThread2.start();
        myThread3.start();
    }

}
