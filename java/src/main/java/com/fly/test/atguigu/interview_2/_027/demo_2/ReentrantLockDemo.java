package com.fly.test.atguigu.interview_2._027.demo_2;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable {
	
	public synchronized void sendSMS() throws Exception {
		System.out.println(Thread.currentThread().getName() + "\tinvoked sendSMS()");
		sendEmail();
	}
	
	public synchronized void sendEmail() throws Exception {
		System.out.println(Thread.currentThread().getName() + "\t#####invoked sendEmail()");
	}
	
	Lock lock = new ReentrantLock();

	@Override
	public void run() {
		get();
	}
	
	public void get() {
		lock.lock();
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\tinvoked get()");
			set();
		} finally {
			lock.unlock();
			lock.unlock();
		}
	}
	
	public void set() {
		lock.lock();
		try {
			System.out.println(Thread.currentThread().getName() + "\t#####invoked set()");
		} finally {
			lock.unlock();
		}
	}

}

/**
 * 可重入锁（也叫做递归锁）
 *		指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 *		在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 *		也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 *
 * case one——​synchronized就是一个典型的可重入锁
 * 		T1	invoked sendSMS()
 * 		T1	#####invoked sendEmail()
 * 		T2	invoked sendSMS()
 * 		T2	#####invoked sendEmail()
 * 
 * case two——​synchronized也是一个典型的可重入锁
 */
public class ReentrantLockDemo {

	public static void main(String[] args) {
		Phone phone = new Phone();
		
		new Thread(() -> {
			try {
				phone.sendSMS();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "T1").start();
		
		new Thread(() -> {
			try {
				phone.sendSMS();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "T2").start();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		
		Thread t3 = new Thread(phone);
		Thread t4 = new Thread(phone);
		t3.start();
		t4.start();
	}
	
}
