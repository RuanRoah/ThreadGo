package com.roah.thread.chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class SimpleWaitAndNotify {
    final static Object object = new Object();

    public static class Thread1 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":线程1开始!");
                try {
                    System.out.println(System.currentTimeMillis() + ":线程一等待，挂机 !");
                    object.wait();
                    System.out.println(System.currentTimeMillis() + ":线程一被唤醒 !");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":线程1结束!");
            }
        }
    }

    public static class Thread2 extends Thread {
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + ":线程2开始 ! 唤醒一个线程");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":线程2已经使用唤醒技能");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":线程2结束!");
            }
        }
    }

    public static void main(String args[]) {
        Thread thread1 = new Thread1();
        Thread thread2 = new Thread2();
        thread1.start();
        thread2.start();
    }

}
