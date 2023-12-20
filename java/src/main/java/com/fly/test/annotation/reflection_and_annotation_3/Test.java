package com.fly.test.annotation.reflection_and_annotation_3;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

@TestAnnotation(msg = "hello")
public class Test {

	@Check(value = "hi")
	int a;

	@Perform
	public void testMethod() {
	}

	@SuppressWarnings("deprecation")
	public void test1() {
		Hero hero = new Hero();
		hero.say();
		hero.speak();
	}

	public static void main(String[] args) {
		// 检查 Test 类中是否使用 TestAnnotation 注解
		boolean hasAnnotation = Test.class.isAnnotationPresent(TestAnnotation.class);

		if (hasAnnotation) {
			// 获取 Test 类的 TestAnnotation 注解
			TestAnnotation testAnnotation = Test.class.getAnnotation(TestAnnotation.class);
			System.out.println("id:" + testAnnotation.id());
			System.out.println("msg:" + testAnnotation.msg());
		}

		try {
			// 获取 Test 类的属性 a 
			Field a = Test.class.getDeclaredField("a");
			a.setAccessible(true);
			// 获取 Test 类的属性 a 中的 Check 注解
			Check check = a.getAnnotation(Check.class);
			if (check != null) {
				System.out.println("check value:" + check.value());
			}

			// 获取 Test 类的 testMethod 方法的类属性
			Method testMethod = Test.class.getDeclaredMethod("testMethod");
			if (testMethod != null) {
				// 获取方法中的注解
				Annotation[] ans = testMethod.getAnnotations();
				for (int i = 0; i < ans.length; i++) {
					System.out.println("method testMethod annotation:" + ans[i].annotationType().getSimpleName());
				}
			}
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		}
	}

}
