package com.roah.thread.chapter3.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class ExtThreadPool {

    public static class MyTask implements Runnable {
        public String name;

        public MyTask(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println("Thread ID:" + Thread.currentThread().getId() + ",Task Name:" + name);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = new ThreadPoolExecutor(5, 5, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque<Runnable>()) {
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("加载前" + ((MyTask) r).name);
            }

            protected void afterExecute(Thread t, Runnable r) {
                System.out.println("加载后:" + ((MyTask) r).name);
            }

            protected void terminated() {
                System.out.println("我靠我终止了："+Thread.currentThread().getName());
            }
        };

        for (int i = 0; i < 5; i++) {
            MyTask task = new MyTask("TASK-Test-" + i);
            executorService.execute(task);
            Thread.sleep(10);
        }
        executorService.shutdown();
    }
}
