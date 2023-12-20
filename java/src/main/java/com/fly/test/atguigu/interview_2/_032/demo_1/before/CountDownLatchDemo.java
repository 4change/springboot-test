package com.fly.test.atguigu.interview_2._032.demo_1.before;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		for (int i = 1; i <= 6; i++) {
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "\t 上完自习，离开教室");
			}, String.valueOf(i)).start();
		}
		
		System.out.println(Thread.currentThread().getName() + "\t 班长最后关门走人");
	}

}
