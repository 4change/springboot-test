package com.fly.test.deep_think_jvm_2.chapter3._3_6;

import org.junit.Test;

public class TestPretenureSizeThreshold {
	
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM 参数：
	 * 	-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
	 */
	@Test
	public void test() {
		byte[] allocation;
		allocation = new byte[4 * _1MB];	// 直接分配在老年代中
	}

}
