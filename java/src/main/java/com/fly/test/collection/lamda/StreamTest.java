package com.fly.test.collection.lamda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Description:
 * @Auther: gongxiangfei
 * @Date: 2020/11/5 11:14
 */
public class StreamTest {

    @Test
    public void test() {

        List<String> sources = new ArrayList<>();
        sources.add("A");
        sources.add("B");
        sources.add("C");
        sources.add("A1");
        sources.add("B1");
        sources.add("C1");


        int goodsCount = 1500;
        //按照1000分割  每一千个商品一个线程
        int limit = (3450 + goodsCount - 1) / goodsCount;
        List<List<String>> mglist = new ArrayList<>();
        Stream.iterate(0, n -> n + 1).limit(limit).forEach(i -> {
            mglist.add(sources.stream().skip(i * goodsCount).limit(goodsCount).collect(Collectors.toList()));
        });

        System.out.println(mglist);

    }

}
