package com.fly.test.collection.queue.productor_consumer.pc;

import java.util.concurrent.LinkedBlockingDeque;

public class Test {

	public static void main(String[] args) {
		LinkedBlockingDeque<String> blockingDeque = new LinkedBlockingDeque<>(1);
		ProducerThread producerThread = new ProducerThread(blockingDeque);
		ConsumerThread consumerThread = new ConsumerThread(blockingDeque);
		Thread t1 = new Thread(producerThread, "生产者");
		Thread t2 = new Thread(consumerThread, "消费者");
		t1.start();
		t2.start();

		// 10秒后停止线程
		try {
			Thread.sleep(10 * 1000);
			producerThread.stop();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
