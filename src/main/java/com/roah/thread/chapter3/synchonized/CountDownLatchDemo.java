package com.roah.thread.chapter3.synchonized;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch Demo
 *
 * CountDownLatch主要目的类似join，主线程必须等待所有线程结束
 * @author Roah
 * @since 09/22/2018
 */
public class CountDownLatchDemo implements Runnable{
    static final CountDownLatch end = new CountDownLatch(10);
    static final CountDownLatchDemo demo = new CountDownLatchDemo();

    @Override
    public void run() {

        try {
            Thread.sleep(new Random().nextInt(3) * 1000);
            System.out.println("线程"+Thread.currentThread().getName()+"检查完成");
            end.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String args[]) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(demo);
        }
        end.await();
        System.out.println("发射!");
        executorService.shutdown();
    }
}
