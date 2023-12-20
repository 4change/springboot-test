package com.fly.test.annotation.reflection_and_annotation_3;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

// 注解
@Retention(RetentionPolicy.RUNTIME) 
public @interface Check {
	// 注解的属性——value
	String value();
}
