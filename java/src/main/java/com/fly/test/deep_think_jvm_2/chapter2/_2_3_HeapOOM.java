package com.fly.test.deep_think_jvm_2.chapter2;

import java.util.ArrayList;
import java.util.List;

public class _2_3_HeapOOM {

    static class OOMObject {
    }

    /**
     * VM Args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     *
     * @param args
     */
    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
