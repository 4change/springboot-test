package com.fly.test.atguigu.interview_2;

import java.util.Random;

/**
 * -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:+PrintCommandLineFlags -XX:+UseConcMarkSweepGC         (par new generation + concurrent mark-sweep generation + serial old generation)
 */
public class GCDemo {

    public static void main(String[] args) {
        System.out.println("**************GCDemo hello");
        try {
            String str = "atguigu";

            while(true) {
                str += str + new Random().nextInt(1111111111) + new Random().nextInt(2222222);
                str.intern();
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

}
