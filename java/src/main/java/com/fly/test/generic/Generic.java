package com.fly.test.generic;

// 此处 T 可以随便写为任意标识，常见的如 T,E,K,V 等形式的参数常用于表示泛型
// 在实例化泛型类时，必须指定 T 的具体类型
public class Generic<T> {

    // key 这个成员变量的类型为 T, T 的类型由外部指定
    private T key;

    // 泛型构造方法形参 key 的类型也为T, T 的类型由外部指定
    public Generic(T key) {
        this.key = key;
    }

    // 泛型方法 getKey 的返回值类型为 T，T 的类型由外部指定
    public T getKey(){
        return key;
    }

}
