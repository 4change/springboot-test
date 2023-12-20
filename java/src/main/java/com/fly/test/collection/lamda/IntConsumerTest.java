package com.fly.test.collection.lamda;

import java.util.function.IntConsumer;

public class IntConsumerTest {

    public static void main(String[] args) {
        start(e -> System.out.print("Release year: " + e), 2010);
    }

    public static void start(IntConsumer cons, int d) {
        cons.accept(d);
    }

}
