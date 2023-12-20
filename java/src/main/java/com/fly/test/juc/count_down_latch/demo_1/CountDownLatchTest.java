package com.fly.test.juc.count_down_latch.demo_1;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest {

	public static void main(String[] args) {
		// CountDownLatch，计数器，初始值为 2
		final CountDownLatch latch = new CountDownLatch(2);		// count: 2

		new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
					Thread.sleep(3000);
					System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
					// 计数器值减一
					latch.countDown();							// count: 1
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		new Thread() {
			@Override
			public void run() {
				try {
					System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
					Thread.sleep(3000);
					System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
					// 计数器值减一
					latch.countDown();							// count: 0
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			};
		}.start();

		try {
			System.out.println("等待2个子线程执行完毕...");
			// 主线程等待所有子线程执行完毕
			latch.await();
			System.out.println("2个子线程已经执行完毕");
			System.out.println("主线程执行完毕---------------------------------------------------------");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
