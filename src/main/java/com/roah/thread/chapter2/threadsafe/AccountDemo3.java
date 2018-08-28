package com.roah.thread.chapter2.threadsafe;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/27/2018
 */
public class AccountDemo3 implements Runnable {
    static AccountDemo3 instance = new AccountDemo3();
    static volatile int i = 0;

    public synchronized void increase() {
        i++;
    }

    @Override
    public synchronized void run() {
        for (int i = 0; i < 100000; i++) {
            increase();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new AccountDemo3());
        Thread thread2 = new Thread(new AccountDemo3());
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}