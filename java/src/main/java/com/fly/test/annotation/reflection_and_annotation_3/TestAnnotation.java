package com.fly.test.annotation.reflection_and_annotation_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)					// 注解的作用域
@Retention(RetentionPolicy.RUNTIME)			// 注解的编译策略
public @interface TestAnnotation {
	// 注解的属性——id
	public int id() default -1;
	// 注解的属性——msg
	public String msg() default "Hi";
}
