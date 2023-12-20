package com.fly.test.final_test;

/**
 * @Description:
 * @Auther: gongxiangfei
 * @Date: 2020/11/3 14:23
 */
public class FinalTest {

    public static void main(String[] args)  {
        MyClass myClass1 = new MyClass();
        MyClass myClass2 = new MyClass();
        System.out.println(myClass1.i);
        System.out.println(myClass1.j);
        System.out.println(myClass2.i);
        System.out.println(myClass2.j);
    }
}

class MyClass {
    int tmp =0;
    public final double i = tmp++;
    public static double j = Math.random();
}
