package com.fly.test.atguigu.interview_2._023;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 集合类不安全的问题
 *
 */
public class ContainerNotSafeDemo {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
//		Map<String, String> map = new Hashtable<String, String>();
//		Map<String, String> map = Collections.synchronizedMap(new HashMap<String, String>());
//		Map<String, String> map = new ConcurrentHashMap<String, String>();
		for (int i = 1; i <= 30; i++) {
			new Thread(() -> {
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
				System.out.println(map);
			}, String.valueOf(i)).start();
		}
	}

}
