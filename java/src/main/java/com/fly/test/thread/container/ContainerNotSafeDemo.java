package com.fly.test.thread.container;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全的问题
 *      ArrayList
 */
public class ContainerNotSafeDemo {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();                                    // ① 并发不安全
//        List<String> list = new Vector<>();                                       // ② 并发安全
//        List<String> list = Collections.synchronizedList(new ArrayList<>());      // ③ 并发安全
        List<String> list = new CopyOnWriteArrayList<>();                           // ④ 并发安全
        list.add("a");
        list.add("b");
        list.add("c");

        for (int i = 0; i < 30; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }, String.valueOf(i)).start();
        }

        // java.util.ConcurrentModificationException

        /**
         * 不要只是会用，会用只不过是一个API调用工程师
         *  底层原理？
         *
         * 1 故障现象
         *      java.util.ConcurrentModificationException
         *
         * 2 导致原因
         *      并发争抢修改导致，参考我们的花名册签名情况。
         *      一个人正在写入，另外一个同学过来争抢，导致数据不一致异常。并发修改异常。
         *
         * 3 解决方案
         *      3.1 new Vector();       // synchronized, 早于ArrayList
         *      3.2 Collections.synchronizedList(new ArrayList<>());
         *      3.3 ???
         *
         * 4 优化建议(同样的错误不犯第2次)
         *
         */
    }

}
