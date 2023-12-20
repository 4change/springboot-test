package com.fly.test.atguigu.interview_2._058;

/**
 * 在 Java 中，可作为 GC Root 的对象有：
 * 		1. 虚拟机栈中（栈帧中的本地变量表）引用的对象
 * 		2. 方法区中类静态属性引用的对象
 * 		3. 方法去中常量引用的对象
 * 		4. 本地方法栈中JNI（即一般说的 Native 方法）中引用的对象
 *
 */
public class GCRootDemo {

	private byte[] byteArray = new byte[100 * 1024 *1024];

	private static GCRootDemo t2 = new GCRootDemo();			// 2
	private static final GCRootDemo t3 = new GCRootDemo();		// 3

	public static void m1() {									// 1
		GCRootDemo t1 = new GCRootDemo();
		System.gc();
		System.out.println("第一次GC完成");
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
	}

	public static void main(String[] args) {
		m1();
	}

}
