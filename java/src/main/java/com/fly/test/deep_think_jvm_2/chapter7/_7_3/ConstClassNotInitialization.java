package com.fly.test.deep_think_jvm_2.chapter7._7_3;

/**
 * 被动使用类字段演示三：
 * 		常量在编译阶段会存入调用类的常量池中，本质上并没有引用到定义常量的类，因此不会出发定义常量的类的初始化 
 *
 */
public class ConstClassNotInitialization {

	public static void main(String[] args) {
		System.out.println(ConstClass.HELLOWORLD);
	}
	
}
