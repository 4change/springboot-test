package com.fly.test.atguigu.interview_2._044;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyResource {
	private volatile boolean FLAG = true;	// 默认开启，进行生产+消费
	private AtomicInteger atomicInteger = new AtomicInteger();
	
	BlockingQueue<String> blockingQueue = null;
	public MyResource(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
		System.out.println(blockingQueue.getClass().getName());
	}
	
	public void myProd() throws Exception {
		String data = null;
		boolean retValue;
		
		while (FLAG) {
			data = atomicInteger.getAndIncrement() + "";
			retValue = blockingQueue.offer(data, 2L, TimeUnit.SECONDS);
			if (retValue) {
				System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "成功");
			} else {
				System.out.println(Thread.currentThread().getName() + "\t 插入队列" + data + "失败");
			}
			TimeUnit.SECONDS.sleep(1);
		}
		System.out.println(Thread.currentThread().getName() + "\t大老板叫停了，表示FLAG=false，生产动作结束");
	}
	
	public void myCustomer() throws Exception {
		String result = null;
		
		while (FLAG) {
			result = blockingQueue.poll(2L, TimeUnit.SECONDS);
			if (result == null || result.equalsIgnoreCase("")) {
				FLAG = false;
				System.out.println(Thread.currentThread().getName() + "\t 超过2秒钟没有取到蛋糕，消费退出");
				System.out.println();
				System.out.println();
				return;
			}
			System.out.println(Thread.currentThread().getName() + "\t 消费蛋糕队列" + result + "成功");
		}
	}
	
	public void stop() {
		this.FLAG = false;
	}
}

/**
 * volatile/CAS/AtomicInteger/BlockingQueue/线程交互/原子引用
 *
 */
public class ProducerCustomerBlockingQueueDemo {

	public static void main(String[] args) {
		MyResource myResource = new MyResource(new ArrayBlockingQueue<String>(10));
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "\t 生产线程启动");
			try {
				myResource.myProd();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "Prod").start();
		
		new Thread(() -> {
			System.out.println(Thread.currentThread().getName() + "\t 消费线程启动");
			try {
				myResource.myCustomer();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}, "Customer").start();
		
		// 暂停一会线程
		try {
			TimeUnit.SECONDS.sleep(5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println();
		System.out.println();
		System.out.println();
		
		System.out.println("5秒钟时间到，大老板main线程叫停，活动结束");
		
		myResource.stop();
	}

}
