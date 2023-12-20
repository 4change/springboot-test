package com.fly.test.atguigu.interview_2;

import java.util.ArrayList;
import java.util.List;

public class GCOverheadDemo {

    // java.lang.OutOfMemoryError: GC overhead limit exceeded

    /**
     * VM Options: -Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
     *
     * @param args
     */
    public static void main(String[] args) {
        int i = 0;
        List<String> list = new ArrayList<>();

        try {
            while (true) {
                list.add(String.valueOf(++i).intern());
            }
        } catch (Throwable e) {
            System.out.println("***************i" + i);
            e.printStackTrace();
            throw e;
        }
    }

}
