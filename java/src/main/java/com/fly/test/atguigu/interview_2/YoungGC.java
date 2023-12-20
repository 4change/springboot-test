package com.fly.test.atguigu.interview_2;

public class YoungGC {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("*************HelloGC");
//        Thread.sleep(Integer.MAX_VALUE);
        byte[] byteArray = new byte[50 * 1024 * 1024];

        Thread.sleep(Integer.MAX_VALUE);
    }

}
