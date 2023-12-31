package com.fly.test.thread.volatile_test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData {      //      MyData.java ===> MyData.class ===> JVM字节码
    volatile int number = 0;

    public void addTo60() {
        this.number = 60;
    }

    /**
     * 请注意，此时number前面是加了volatile关键字修饰的，volatile不保证原子性。
     */
//    public synchronized void addPlusPlus() {            // synchronized 保证原子性
    public void addPlusPlus() {
        number++;
    }

    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic() {
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1. 验证 volatile 的可见性
 *      1.1 假如 int number = 0, number 变量之前根本没有添加 volatile 关键字修饰, 没有可见性
 *      1.2 添加了volatile, 可以解决可见性问题
 *
 * 2. 验证volatile不保证原子性
 *      2.1 原子性指的是什么意思？
 *          不可分割，完整性，也即某个线程正在做某个业务时，中间不可以被加塞或者被分割。
 *          需要整体完整，要么同时成功，要么同时失败
 *
 *      2.2 volatile不保证原子性的案例演示
 *
 *      2.3 why
 *
 *      2.4 如何解决原子性？
 *          * synchronized
 *          * 使用JUC下AtomicInteger
 */
public class VolatileDemo {

    /**
     * main 是一切方法的运行入口
     *
     * @param args
     */
    public static void main(String[] args) {
        MyData myData = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                for (int j = 1; j <= 1000; j++) {
                    myData.addPlusPlus();
                    myData.addMyAtomic();
                }
            }, String.valueOf(i)).start();
        }

        /**
         * 需要等待上面20个线程全部都计算完成后，再用main线程取得最终的结果值看是多少？
         *      activeCount(): 默认值为2, 后台始终会保留2个线程(main线程 和 GC线程)
         */
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type, finally number value: " + myData.number);
        System.out.println(Thread.currentThread().getName() + "\t AtomicInteger type,  finally number value: " + myData.atomicInteger);
    }

    /**
     * volatile 可以保证可见性，及时通知其他线程，主物理内存的值已经被修改
     */
    private static void seeOkByVolatile() {
        // 资源类
        MyData myData = new MyData();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "\t come in");
            // 暂停一会线程
            try { TimeUnit.SECONDS.sleep(3); } catch (InterruptedException e) { e.printStackTrace(); }
            myData.addTo60();
            System.out.println(Thread.currentThread().getName() + "\t updated value:" + myData.number);
        }, "AAA").start();


        // 第二个线程就是我们的main线程
        while (myData.number == 0) {
            // main 线程就一直在这里循环等待，直到number值不再等于0
        }

        // 输出结果不为 200000, 以此证明 volatile 不保证原子性
        System.out.println(Thread.currentThread().getName() + "\t mission is over, main get number value:" + myData.number);
    }

}
