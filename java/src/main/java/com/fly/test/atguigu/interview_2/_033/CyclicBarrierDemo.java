package com.fly.test.atguigu.interview_2._033;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {

	public static void main(String[] args) {
		CyclicBarrier cyclicBarrier = new CyclicBarrier(7, () -> { System.out.println("**********召唤神龙"); });
		
		for (int i = 1; i <= 7; i++) {
			final int tempInt = i;
			new Thread(() -> {
				System.out.println(Thread.currentThread().getName() + "\t 收集到第 " + tempInt + " 颗龙珠");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException | BrokenBarrierException e) {
					e.printStackTrace();
				}
			}, String.valueOf(i)).start();
		}
	}

}
