package com.fly.test.deep_think_jvm_2.chapter3._3_8;

import org.junit.Test;

public class MyTest {
	
	private static final int _1MB = 1024 * 1024;
	
	/**
	 * VM 参数：
	 * 	-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1
	 */
	@Test
	public void testTenuringThreshold() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[_1MB / 4];
		// allocation1 + allocation2 大于 survivor 空间一半
//		allocation2 = new byte[_1MB / 4];
		allocation3 = new byte[4 * _1MB];
		allocation4 = new byte[4 * _1MB];
		allocation4 = null;
		allocation4 = new byte[4 * _1MB];
	}
	
//	public static void main(String[] args) {
//		testTenuringThreshold();
//	}

}
