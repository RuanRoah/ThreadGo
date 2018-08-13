package com.roah.thread.chapter2;

/**
 * join方法实例
 *
 * @author Roah
 * @since 08/13/2018
 */
public class JoinTest {
    public volatile static int i = 0;

    public static class AddThread extends Thread {
        public void run() {
            System.out.println("add!");
            for (i = 0; i < 1000000; i++) ;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        AddThread at = new AddThread();
        at.start();
        at.join();
        System.out.println(i);
    }
}
