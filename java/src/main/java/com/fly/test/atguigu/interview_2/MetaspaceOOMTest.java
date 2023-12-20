package com.fly.test.atguigu.interview_2;

public class MetaspaceOOMTest {

    public static void main(String[] args) {
        int i = 0;  // 模拟计数多少次以后发生异常

        try {
            while (true) {
                i++;
            }
        } catch (Throwable e) {

        }
    }

}
