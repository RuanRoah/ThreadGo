package com.roah.thread.chapter3.threadpool;

import java.util.concurrent.*;

/**
 * 线程池Test
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable {

        @Override
        public void run() {
            System.out.println(System.currentTimeMillis() + "Thread ID:" + Thread.currentThread().getId());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) {
        MyTask myTask = new MyTask();
        System.out.println(Runtime.getRuntime().availableProcessors());
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 20; i++) {
            executorService.submit(myTask);
        }

        ExecutorService executorService1 = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 20; i++) {
            executorService1.submit(myTask);
        }

        ExecutorService executorService2 = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>());
        executorService2.submit(myTask);

    }
}