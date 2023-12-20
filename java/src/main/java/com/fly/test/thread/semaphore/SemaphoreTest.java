package com.fly.test.thread.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreTest {

    /**
     * 第一步：定义一个信号量Semaphore
     */
    static Semaphore sp = new Semaphore(3);

    public static void main(String[] args) {
        // 第二步：定义10个学生去打饭
        for (int i = 0; i < 10; i++) {
            // 十个学生用一个信号量
            new Student(sp, "学生" + i).start();
        }
    }
}