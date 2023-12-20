package com.fly.test.thread.thread_pool.executor_completion_service;

import java.util.Random;
import java.util.concurrent.*;

public class ConcurrentTest {

    static final int TOTAL_TASK = 1000;
    private static final ExecutorService executorService = new ThreadPoolExecutor(16, 16,
            60L, TimeUnit.SECONDS, new LinkedBlockingQueue<>());
    BlockingQueue<Future<String>> blockingQueue = new LinkedBlockingQueue<>();

    public static void main(String[] args) throws Exception {
        ConcurrentTest concurrentTest = new ConcurrentTest();

        long currentTime = System.currentTimeMillis();
        concurrentTest.testConcurrentNotWithQueue();
        System.out.println("testConcurrentNotWithQueue cost=" + (System.currentTimeMillis() - currentTime));
        System.out.println("--------------------------------------------------------------------");

        long currentTime1 = System.currentTimeMillis();
        concurrentTest.testConcurrentWithQueue();
        System.out.println("testConcurrentWithQueue cost=" + (System.currentTimeMillis() - currentTime1));
        System.out.println("--------------------------------------------------------------------");

        long currentTime2 = System.currentTimeMillis();
        concurrentTest.testConcurrentWithCompletionService();
        System.out.println("testConcurrentWithCompletionServic cost=" + (System.currentTimeMillis() - currentTime2));

        executorService.shutdown();
    }

    /**
     * 异步提交任务, 提交后便立即等待线程执行结果返回, 此为异步阻塞式执行
     *
     * @throws Exception
     */
    public void testConcurrentNotWithQueue() throws Exception {
        for (int i = 0; i < TOTAL_TASK; i++) {
            Future<String> future = executorService.submit(new MyThread("thread-" + i));
            System.out.println("testConcurrentNotWithQueue:" + future.get());
        }
    }

    /**
     * 异步提交任务, 将任务同时添加进线程池和阻塞队列, 并在任务执行结束后统一返回执行结果, 按提交顺序返回, 此为异步并发执行
     *
     * @throws Exception
     */
    public void testConcurrentWithQueue() throws Exception {
        for (int i = 0; i < TOTAL_TASK; i++) {
            Future<String> future = executorService.submit(new MyThread("thread-" + i));
            // 如果不加入队列，则需要一个一个等待获取结果
            blockingQueue.add(future);
        }

        // 获取任务结果
        for (int i = 0; i < TOTAL_TASK; i++) {
            System.out.println("testConcurrentWithQueue:" + blockingQueue.take().get());
        }
    }

    /**
     * 异步提交任务, 先执行完的先返回, 异步并发执行
     *
     * @throws Exception
     */
    public void testConcurrentWithCompletionService() throws Exception {
        CompletionService<String> completionService = new ExecutorCompletionService<>(executorService);

        for (int i = 0; i < TOTAL_TASK; i++) {
            completionService.submit(new MyThread("thread-" + i));
        }

        // 获取任务结果
        for (int i = 0; i < TOTAL_TASK; i++) {
            Future<String> future = completionService.take();
            System.out.println("testConcurrentWithCompletionService:" + future.get());
        }
    }

    class MyThread implements Callable<String> {
        private String name;

        public MyThread(String name) {
            this.name = name;
        }

        @Override
        public String call() {
            int sleepTime = new Random().nextInt(1000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // 返回给调用者的值
            String str = name + " sleep time:" + sleepTime;
            System.out.println(name + " execute finished");

            return str;
        }
    }
}
