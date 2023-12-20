package com.fly.test.deep_think_jvm_2.chapter2;

import java.util.HashSet;
import java.util.Set;

public class _2_7_RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        // 使用Set保持着常量池引用， 避免Full GC回收常量池行为
        Set<String> set = new HashSet<>();
        // 在short范围内足以让6MB的PermSize产生OOM了
        short i = 0;
        while (true) {
            set.add(String.valueOf(i++).intern());
        }
    }

}
