package com.fly.test.util;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.apache.commons.math3.util.Pair;

public class WeightRandom<K,V extends Number> {
    private final TreeMap<Double, K> weightMap = new TreeMap<>();

    public WeightRandom(List<Pair<K, V>> list) {
        for (Pair<K, V> pair : list) {
            double lastWeight = this.weightMap.size() == 0 ? 0 : this.weightMap.lastKey();//统一转为double
            this.weightMap.put(pair.getValue().doubleValue() + lastWeight, pair.getKey());//权重累加
        }
    }

    public K random() {
        double randomWeight = this.weightMap.lastKey() * Math.random();
        SortedMap<Double, K> tailMap = this.weightMap.tailMap(randomWeight, true);
        return this.weightMap.get(tailMap.firstKey());
    }

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