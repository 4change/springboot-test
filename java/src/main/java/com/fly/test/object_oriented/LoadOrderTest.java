package com.fly.test.object_oriented;

class A {
    // 构造函数
    public A() {
        System.out.println("class A");
    }

    // 构造代码块
    {
        System.out.println("I'm A class");
    }

    // 静态代码块
    static {
        System.out.println("class A static");
    }
}

class B extends A {
    public B() {
        System.out.println("class B");
    }

    {
        System.out.println("I'm B class");
    }

    static {
        System.out.println("class B static");
    }
}

public class LoadOrderTest {

    public static void main(String[] args) {
        new B();
    }

}
