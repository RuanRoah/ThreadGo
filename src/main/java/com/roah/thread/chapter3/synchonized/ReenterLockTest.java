package com.roah.thread.chapter3.synchonized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁Demo
 *
 * @author Roah
 * @since 09/22/2018
 */
public class ReenterLockTest implements Runnable{
    public static ReentrantLock lock = new ReentrantLock();
    public static int i = 0;

    @Override
    public void run() {
        for (int j = 0; j < 1000000; j++) {
            lock.lock();
            lock.lock();
            try {
                i++;
            } finally {
                lock.unlock();
                //Demo演示的时候，最好带上双重锁头
            }

        }
    }

    public static void main(String args[]) throws InterruptedException {
        ReenterLockTest reenterLock = new ReenterLockTest();
        Thread thread1 = new Thread(reenterLock);
        Thread thread2 = new Thread(reenterLock);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(i);
    }

}
