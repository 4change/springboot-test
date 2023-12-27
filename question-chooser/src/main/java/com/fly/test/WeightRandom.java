package com.fly.test;

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
        list.add(new Pair<>("A", 0.20));
        list.add(new Pair<>("C", 0.50));
        list.add(new Pair<>("B", 0.30));

        WeightRandom<String, Double> weightRandom = new WeightRandom<>(list);
        Object random = weightRandom.random();
        System.out.println("----Key----"+random);
    }

}