package com.fly.test.collection.lamda;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author gongxiangfei
 * @description
 * @date 2020/12/9 10:23
 */
public class LambdaTest {

    @Test
    public void test() {
        List<Person> list = new LinkedList<>();
        list.add(new Person(1, "1"));
        List<String> collect =
                list.parallelStream().filter(Objects::nonNull).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect);
    }

}
