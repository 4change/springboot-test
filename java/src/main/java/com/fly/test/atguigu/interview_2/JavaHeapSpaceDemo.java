package com.fly.test.atguigu.interview_2;

import java.util.Random;

public class JavaHeapSpaceDemo {

    /**
     * VM Options: -Xms10m -Xmx10m -XX:+PrintGCDetails
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "atguigu";

        while(true) {
            str += str + new Random().nextInt(1111111111) + new Random().nextInt(2222222);
            str.intern();
        }
    }

}
