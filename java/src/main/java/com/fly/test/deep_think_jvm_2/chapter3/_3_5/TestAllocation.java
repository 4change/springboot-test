package com.fly.test.deep_think_jvm_2.chapter3._3_5;

import org.junit.Test;

public class TestAllocation {
	
	private static final int _1MB = 1024 * 1024;

	/**
	 * VM 参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
	 * 
	 */
	@Test
	public void testAllocation() {
		byte[] allocation1, allocation2, allocation3, allocation4;
		allocation1 = new byte[2 * _1MB];
		allocation2 = new byte[2 * _1MB];
		allocation3 = new byte[2 * _1MB];
		// 这里为什么没有触发 Minor GC　？
		allocation4 = new byte[4 * _1MB];		// 出现一次 Minor GC
	}

}
