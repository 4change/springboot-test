package com.fly.test.atguigu.interview_2._027.demo_1;

class Phone {
	
	public synchronized void sendSMS() throws Exception {
		System.out.println(Thread.currentThread().getName() + "\tinvoked sendSMS()");
		sendEmail();
	}
	
	public synchronized void sendEmail() throws Exception {
		System.out.println(Thread.currentThread().getName() + "\t#####invoked sendEmail()");
	}
	
}

/**
 * 可重入锁（也叫做递归锁）
 *		指的是同一线程外层函数获得锁之后，内层递归函数仍然能获取该锁的代码，
 *		在同一个线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 *		也即是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
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
	}
	
}
