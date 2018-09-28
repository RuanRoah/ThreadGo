package com.roah.thread.chapter3;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatch Demo
 *
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
            System.out.println("check complete");
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
        System.out.println("Fire!");
        executorService.shutdown();
    }
}
