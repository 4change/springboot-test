package com.fly.test.thread.condition.demo_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionUseCase {

	public Lock lock = new ReentrantLock();
	// Condition 的创建依赖于 Lock
	public Condition condition = lock.newCondition();

	public static void main(String[] args) {
		ConditionUseCase useCase = new ConditionUseCase();
		// 大小为2的线程池
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				useCase.conditionWait();
			}
		});
		executorService.execute(new Runnable() {
			@Override
			public void run() {
				useCase.conditionSignal();
			}
		});
	}

	public void conditionWait() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "拿到锁了");
			System.out.println(Thread.currentThread().getName() + "等待信号");
			// 调用这部分代码的线程阻塞在这里，等待信号，只有拿到信号了才会继续执行后面的代码
			condition.await();
			System.out.println(Thread.currentThread().getName() + "拿到信号");
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

	public void conditionSignal() {
		lock.lock();
		try {
			Thread.sleep(5000);
			System.out.println(Thread.currentThread().getName() + "拿到锁了");
			// 调用这部分代码的线程发出信号，通知另外一个线程恢复执行
			condition.signal();
			System.out.println(Thread.currentThread().getName() + "发出信号");
		} catch (Exception e) {
		} finally {
			lock.unlock();
		}
	}

}
