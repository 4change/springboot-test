package com.fly.test;

import org.apache.commons.math3.util.Pair;

import java.util.ArrayList;
import java.util.List;

public class QuestionChooser {

    public static void main(String[] args) {
        List<Pair<String,Double>> list = new ArrayList<>();
        list.add(new Pair<>("分布式", 25.0));
        list.add(new Pair<>("Java", 20.0));
        list.add(new Pair<>("数据库", 15.0));
        list.add(new Pair<>("Redis", 15.0));
        list.add(new Pair<>("消息队列", 10.0));
        list.add(new Pair<>("设计模式", 5.0));
        list.add(new Pair<>("操作系统", 5.0));
        list.add(new Pair<>("计算机网络", 5.0));

        WeightRandom<String, Double> weightRandom = new WeightRandom<>(list);
        Object random = weightRandom.random();
        System.out.println("----Key----"+random);
    }

}
