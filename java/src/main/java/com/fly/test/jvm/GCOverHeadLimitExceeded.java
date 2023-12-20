package com.fly.test.jvm;

import java.util.Map;
import java.util.Random;

/**
 * @author gongxiangfei
 * @description
 * @date 2021/2/22 14:59
 */
public class GCOverHeadLimitExceeded {

    /**
     * GC overhead limit exceeded
     *
     * VM: -ea -Xmx12m -XX:+UseParallelGC
     *
     * @param args
     * @throws Exception
     */
    public static void main(String args[]) throws Exception {
        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
            System.out.println("program is running ...");
        }
    }

}
