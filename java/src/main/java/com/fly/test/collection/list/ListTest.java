package com.fly.test.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Auther: gongxiangfei
 * @Date: 2020/11/3 15:21
 */
public class ListTest {

    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("B");
        list2.add("D");

        // 并集
//        list1.addAll(list2);
//        System.out.println("并集---------------------------------" + list1 + "--------------------------------" + list2);

        // 去重复并集
//        list2.removeAll(list1);
//        list1.addAll(list2);
//        System.out.println("去重复并集----------------------------" + list1 + "--------------------------------" + list2);

        // 交集
//        list1.retainAll(list2);
//        System.out.println("交集---------------------------------" + list1 + "--------------------------------" + list2);

        // 差集
        list1.removeAll(list2);
        System.out.println("差集---------------------------------" + list1 + "--------------------------------" + list2);
    }

}
