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
            System.out.println("走了！");
            for (i = 0; i < 1000000; i++) ;
            try {
                System.out.println("等等我");
                Thread.sleep(500);
                System.out.println("系好鞋带了");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]) throws InterruptedException {

        AddThread at = new AddThread();
        at.start();
        at.join();//join的目的在于等待线程结束，演示的时候想着注释掉
        System.out.println(i);
    }
}
