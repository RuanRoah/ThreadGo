package com.roah.thread.chapter2.demo;

import com.roah.thread.pojo.User;

/**
 * 强行终止实例
 *
 *
 * @author Roah
 * @since 08/13/2018
 */
public class StopThreadSafe {

    public static User user = new User();



    public static class ChangeObjectThread extends Thread {
        public void run() {
            while (true) {
                synchronized (user) {
                }
                Thread.yield();
            }
        }
    }

    public static class ReadObjectThread extends Thread {
        public void run() {
            while (true) {
                synchronized (user) {

                }
                Thread.yield();
            }
        }
    }


    public static void main(String args[]) throws InterruptedException {
        new ReadObjectThread().start();
        while (true) {
            Thread thread = new ChangeObjectThread();
            thread.start();
            Thread.sleep(150);
        }
    }
}
