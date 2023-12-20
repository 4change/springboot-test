package com.fly.test.atguigu.interview_2;

import java.nio.ByteBuffer;

public class DirectBufferMemoryDemo {

    // Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory

    /**
     * VM Options: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:" + (sun.misc.VM.maxDirectMemory() / (double) 1024 / 1024) + "MB");
        try { Thread.sleep(3000); } catch (InterruptedException e) { e.printStackTrace(); }
        // -XX:MaxDirectMemorySize=5m   我们配置为5MB, 但实际使用6MB, 故意使坏
        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }

}
