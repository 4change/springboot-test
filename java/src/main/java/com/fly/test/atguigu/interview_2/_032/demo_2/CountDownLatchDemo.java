package com.fly.test.atguigu.interview_2._032.demo_2;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "\t 国被灭");
				countDownLatch.countDown();
			}, CountryEnum.forEach_CountryEnum(i).getRetMessage()).start();
		}
		
		countDownLatch.await();
		System.out.println(Thread.currentThread().getName() + "\t ********* 秦帝国，一统华夏");
	}

}
