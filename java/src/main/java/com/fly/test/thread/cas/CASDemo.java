package com.fly.test.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 1. CAS 是什么？  ===> Compare And Set
 *      比较并交换
 */
public class CASDemo {
    public static void main (String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);

        // main do things...

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current value: " + atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(5, 2019) + "\t current value: " + atomicInteger.get());
    }
}
