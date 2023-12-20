package com.fly.test.thread.thread_pool.executor_completion_service;

import org.junit.Test;

import java.util.concurrent.*;

public class ExecutorCompletionServiceTest {

    public static final int THREAD_COUNT = 100;

    @Test
    public void test() throws InterruptedException, ExecutionException {
        Executor executor = Executors.newFixedThreadPool(8);

        CompletionService<String> service = new ExecutorCompletionService<>(executor);
        for (int i = 0; i < THREAD_COUNT; i++) {
            int seqNo = i;
            service.submit(new Callable<String>() {
                @Override
                public String call() {
                    return "HelloWorld-" + seqNo + "-" + Thread.currentThread().getName();
                }
            });
        }

        for (int j = 0; j < THREAD_COUNT; j++) {
            System.out.println(service.take().get());
        }
    }

}
