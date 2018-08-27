package com.roah.thread.chapter2.threadsafe;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/27/2018
 */
public class AccountDemo implements Runnable {
    static AccountDemo instance = new AccountDemo();
    static volatile int i = 0;

    public static void increase() {
        i++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++){
            increase();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}