package com.roah.thread.chapter2.demo;

/**
 * 线程打断Interrupt基础类
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
                    if(Thread.currentThread().isInterrupted()){
                        System.out.println("线程中断，结束");
                        break;
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println("Sleeping!");
                        Thread.currentThread().interrupt();
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
