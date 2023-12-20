package com.fly.test.thread.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Student extends Thread {
    private Semaphore sp = null;
    private String name = null;

    public Student(Semaphore sp, String name) {
        this.sp = sp;
        this.name = name;
    }

    @Override
    public void run() {
        try {
            System.out.println(name + "进入了餐厅");
            sp.acquire();   // 获取信号量
            System.out.println(name + "拿到了打饭的许可");
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(name + "打好了饭，释放这个窗口");
            sp.release();   // 释放信号量
        }
    }
}
