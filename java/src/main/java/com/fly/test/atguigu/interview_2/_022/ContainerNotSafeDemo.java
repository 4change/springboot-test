package com.fly.test.atguigu.interview_2._022;

import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * 集合类不安全的问题
 *
 */
public class ContainerNotSafeDemo {

	public static void main(String[] args) {
//		Set<String> set = new HashSet<String>();
//		Set<String> set = Collections.synchronizedSet(new HashSet<String>());
		Set<String> set = new CopyOnWriteArraySet<String>();
		for (int i = 1; i <= 30; i++) {
			new Thread(() -> {
				set.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(set);
			}, String.valueOf(i)).start();
		}
	}

}
