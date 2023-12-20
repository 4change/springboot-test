package com.fly.test.thread.thread_pool;

import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolTest {
	@Test
	public void test() throws ExecutionException, InterruptedException {
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++) {
			// 通过Future接口创建线程, 需要接收返回值, 否则线程会提前退出
			Future future = executor.submit(() -> {
				System.out.println("thread id is: " + Thread.currentThread().getId());

				try {
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

				return 0;
			});

			System.out.println(future.get());
		}
	}

	@Test
	public void test2() {
		ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);

		// 定时调度，每个调度任务会至少等待`period`的时间，
		// 如果任务执行的时间超过`period`，则等待的时间为任务执行的时间
		executor.scheduleAtFixedRate(() -> {
			try {
				Thread.sleep(10000);
				System.out.println(System.currentTimeMillis() / 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 2, TimeUnit.SECONDS);

		// 定时调度，第二个任务执行的时间 = 第一个任务执行时间 + `delay`
		executor.scheduleWithFixedDelay(() -> {
			try {
				Thread.sleep(5000);
				System.out.println(System.currentTimeMillis() / 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}, 0, 2, TimeUnit.SECONDS);

		// 定时调度，延迟`delay`后执行，且只执行一次
		executor.schedule(() -> System.out.println("5 秒之后执行 schedule"), 5, TimeUnit.SECONDS);
	}

	@Test
	public void test3() {
		ExecutorService executor = new ThreadPoolExecutor(100, 150, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1)) {
			@Override
			protected void beforeExecute(Thread t, Runnable r) {
				System.out.println("beforeExecute is called");
			}

			@Override
			protected void afterExecute(Runnable r, Throwable t) {
				System.out.println("afterExecute is called");
			}

			@Override
			protected void terminated() {
				System.out.println("terminated is called");
			}
		};

		executor.submit(() -> System.out.println("this is a task"));
		executor.shutdown();
	}
}
