package com.roah.thread.chapter2;

/**
 * 线程打断基础类
 *
 * @author Roah
 * @since 08/14/2018
 */
public class InterruptThread {
    public static void main(String args[]) throws InterruptedException {
        Thread thread = new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Running!");
                    Thread.yield();
                }
            }
        };

        thread.start();
        Thread.sleep(2000);
        thread.interrupt();
    }
}
