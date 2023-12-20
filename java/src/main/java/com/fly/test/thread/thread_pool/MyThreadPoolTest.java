package com.fly.test.thread.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MyThreadPoolTest {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        /**
         * 异常执行的情况
         */
//        for (int i = 0; i < 5; i++) {
//            executor.submit(new DivTask(100, i));
//        }

        /**
         * 正常执行的情况
         */
        for (int i = 0; i < 5; i++) {
            Future future= executor.submit(new DivTask(100, i));
            try {
                future.get();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    static class DivTask implements Runnable {
        int a, b;

        public DivTask(int a, int b) {
            this.a = a;
            this.b = b;
        }

        @Override public void run() {
            double result = a / b;
            System.out.println(result);
        }
    }

}
