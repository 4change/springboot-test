package com.fly.test.thread.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // 线程A、B同时运行，线程C在A、B之后运行
        //// 通过Callable接口创建线程A
        Callable<A> a = () -> {
            for (int i = 0; i < 15; i++) {
                System.out.print(" A" + i);
            }
            return new A();
        };
        //// 通过Callable接口创建线程B
        Callable<B> b = () -> {
            for (int i = 0; i < 10; i++) {
                System.out.print(" B" + i);
            }
            return new B();
        };

        FutureTask<A> taskA = new FutureTask<>(a);
        FutureTask<B> taskB = new FutureTask<>(b);
        new Thread(taskA).start();
        new Thread(taskB).start();

        if (taskA.get() != null && taskB.get() != null) {
            new Thread(new C()).start();
        }
    }

    static class A {
    }

    static class B {
    }

    /**
     * 通过继承Thread类创建线程C
     */
    static class C extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.print(" C" + i);
            }
        }
    }
}

