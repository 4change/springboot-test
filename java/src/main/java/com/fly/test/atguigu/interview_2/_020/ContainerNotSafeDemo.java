package com.fly.test.atguigu.interview_2._020;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 集合类不安全的问题
 *
 */
public class ContainerNotSafeDemo {

	public static void main(String[] args) {
		
		//////////////////////////////////////// 单线程 ////////////////////////////////////////
//		List<String> list = Arrays.asList("a", "b", "c");
//		list.forEach(System.out::println);
		
		//////////////////////////////////////// 多线程 ////////////////////////////////////////
		// java.util.ConcurrentModificationException
//		List<String> list = new ArrayList<String>();	// ArrayList——线程不安全
//		List<String> list = new Vector<String>();		// Vector——线程安全
//		List<String> list = Collections.synchronizedList(new ArrayList<String>());	// 线程安全
		List<String> list = new CopyOnWriteArrayList<String>();	// 线程安全
		for (int i = 1; i <= 30; i++) {
			new Thread(() -> {
				list.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(list);
			}, String.valueOf(i)).start();
		}
		
		/**
		 * 1 故障现象
		 * 		java.util.ConcurrentModificationException
		 * 
		 * 2 导致原因
		 * 		并发争抢修改导致，参考我们的花名册签名情况。
		 * 		一个人正在写入，另外一个同学过来抢夺，导致数据不一致异常。并发修改异常。
		 * 
		 * 3 解决方案
		 * 		3.1 new Vector<String>();
		 * 		3.2 Collections.synchronizedList(new ArrayList<String>());
		 * 		3.3 new CopyOnWriteArrayList<String>();
		 * 
		 * 4 优化建议（同样的错误不犯第2次）
		 */
	}

}
