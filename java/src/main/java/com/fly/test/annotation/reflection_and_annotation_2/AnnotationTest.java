package com.fly.test.annotation.reflection_and_annotation_2;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation {
    String[] value() default "unknown";
}

class Person {

    @MyAnnotation
    @Deprecated
    public void empty() {
        System.out.println("empty-------------------------------------------------------------");
    }

    @MyAnnotation(value = {"girl", "boy"})
    public void somebody(String name, int age) {
        System.out.println("somebody: " + name + ", " + age + "-------------------------------");
    }
    
}

public class AnnotationTest {

    public static void main(String[] args) throws Exception {
        Person person = new Person();
        Class<Person> personClass = Person.class;
        // 获取 Person 类的 somebody() 方法的类实例
        Method mSomebody = personClass.getMethod("somebody", new Class[]{String.class, int.class});
        // 执行该方法
        mSomebody.invoke(person, new Object[]{"lily", 18});
        // 遍历注解
        iteratorAnnotations(mSomebody);

        // 获取 Person 类的 empty() 方法的类实例
        Method mEmpty = personClass.getMethod("empty", new Class[]{});
        // 执行该方法
        mEmpty.invoke(person, new Object[]{});
        iteratorAnnotations(mEmpty);
    }

    public static void iteratorAnnotations(Method method) {
        // 判断 method 类代表的方法是否使用 MyAnnotation 注解
        if (method.isAnnotationPresent(MyAnnotation.class)) {
            // 获取 method 方法的 MyAnnotation 注解实例
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            // 获取 myAnnotation的值，并打印出来
            String[] values = myAnnotation.value();
            for (String str : values) 
            	System.out.println("注解MyAnnotation的值--------------------------------------" + str);
        }

        // 获取 method 方法上的所有注解
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            System.out.println("方法上的注解------------------------------------------->" + annotation);
        }
    }
}
