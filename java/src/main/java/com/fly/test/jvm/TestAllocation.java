package com.fly.test.jvm;

import org.junit.Test;

public class TestAllocation {
	
	private static final int _1MB = 1024* 1024;

	/**
	 * VM 参数：
	 * 		verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDateStamps -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+PrintHeapAtGC
	 */
	@Test
    public void testAllocation(){
        byte[] allocation,allocation2,allocation3,allocation4;
        allocation = new byte[2*_1MB];
        allocation2 = new byte[2*_1MB];
        allocation3 = new byte[2*_1MB];
        allocation4 = new byte[4*_1MB];
    }

}
