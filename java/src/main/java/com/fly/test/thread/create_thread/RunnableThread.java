package com.fly.test.thread.create_thread;

public class RunnableThread implements Runnable {

    public static int count = 20;

    @Override
    public void run() {
        while (count > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-当前剩余票数:" + count--);
        }
    }

    public static void main(String[] args) {
        RunnableThread Thread1 = new RunnableThread();
        Thread mThread1 = new Thread(Thread1, "线程1");
        Thread mThread2 = new Thread(Thread1, "线程2");
        Thread mThread3 = new Thread(Thread1, "线程3");
        mThread1.start();
        mThread2.start();
        mThread3.start();
    }

}
