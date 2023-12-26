package com.fly.test.thread.cyclic_barrier.demo_2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class TestRunnable {

	public static void main(String[] args) {
		int N = 4;
		CyclicBarrier barrier = new CyclicBarrier(N, new Runnable() {
			@Override
			public void run() {
				System.out.println("当前线程" + Thread.currentThread().getName() + "执行完毕");
			}
		});

		for (int i = 0; i < N; i++)
			new Writer(barrier).start();
	}

	public static class Writer extends Thread {
		private CyclicBarrier cyclicBarrier;

		public Writer(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			System.out.println("线程" + Thread.currentThread().getName() + "正在写入数据...");
			try {
				Thread.sleep(5000); // 以睡眠来模拟写入数据操作
				System.out.println("线程" + Thread.currentThread().getName() + "写入数据完毕，等待其他线程写入完毕");
				cyclicBarrier.await();	// 挂起当前线程，等待CyclicBarrier中所有线程执行完毕后再返回
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				e.printStackTrace();
			}
            System.out.println(Thread.currentThread().getName() + "所有线程写入完毕，继续处理其他任务...");
		}
	}

}
