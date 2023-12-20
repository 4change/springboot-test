package com.fly.test.collection.lamda;

import com.alibaba.fastjson.JSON;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.stream.Stream;

public class ConsumerTest {

    @Test
    public void testAdd() {
        List<Person> lisiList = new ArrayList<>();

        Consumer<Person> consumer = x -> {
            if (x.name.equals("lisi")) {
                lisiList.add(x);
            }
        };
        Stream.of(
                new Person(21, "zhangsan"),
                new Person(22, "lisi"),
                new Person(23, "wangwu"),
                new Person(24, "wangwu"),
                new Person(23, "lisi"),
                new Person(26, "lisi"),
                new Person(26, "zhangsan")
        ).forEach(consumer);

        System.out.println(JSON.toJSONString(lisiList));
    }

    @Test
    public void testAndThen() {
        List<Person> lisiList = new ArrayList<>();

        Consumer<Person> consumer = x -> {
            if (x.name.equals("lisi")) {
                lisiList.add(x);
            }
        };

        consumer = consumer.andThen(
                x -> lisiList.removeIf(y -> y.age < 23)
        );

        Stream.of(
                new Person(21, "zhangsan"),
                new Person(22, "lisi"),
                new Person(23, "wangwu"),
                new Person(24, "wangwu"),
                new Person(23, "lisi"),
                new Person(26, "lisi"),
                new Person(26, "zhangsan")
        ).forEach(consumer);

        System.out.println(JSON.toJSONString(lisiList));
    }

    @Test
    public void testConsumer() {
        ConsumerTest consumerTest = new ConsumerTest();
        consumerTest.arithmetic(8, 9, System.out::println, System.out::println);

        Consumer<String> consumer = s -> System.out.println(s.toUpperCase());
        consumer.accept("hello");

        consumerTest.arithmetic1(4, 9, System.out::println, (a) -> a = a + 2);
        consumerTest.arithmetic1(4, 9, System.out::println, (a) -> System.out.println(a * 2));
//        consumerTest.arithmetic1(4, 9, System.out::println, (a) -> a * 2);
    }

    public void arithmetic(int i, int s, Consumer<Integer> consumer, Consumer<Integer> consumer1) {
        consumer1.accept(i * s);
        consumer.accept(i + s);
    }

    public void arithmetic1(int a, int b, Consumer<Integer> consumer, Consumer<Integer> consumer1) {
        consumer.andThen(consumer1).accept(a + b);
    }

    @Test
    public void test() {
        consume(e -> System.out.println(e), 2);
    }

    public static void consume(IntConsumer intConsumer, int i) {
        intConsumer.accept(i);
        intConsumer.andThen(e -> System.out.println(e = e + 2)).accept(5);
    }

}
