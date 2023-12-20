package com.fly.test.annotation.reflection_and_annotation_1;

@TestAnnotation
public class Test {

	public static void main(String[] args) {
		// 判断 Test 类是否应用注解 TestAnnotation
		boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);
		if (hasAnnotation) {
			// 获取 Test 类的 TestAnnotation 注解
			TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
			System.out.println("id:" + testAnnotation.id());
			System.out.println("msg:" + testAnnotation.msg());
		}
	}

}