package com.fly.test.deep_think_jvm_2.chapter7._7_2;

/**
 * 被动使用类字段演示二：
 * 		通过数组定义来引用类，不会出发此类的初始化
 *
 */
public class ArrayNotInitialization {

	public static void main(String[] args) {
		SuperClass[] sca = new SuperClass[10];
	}

}
