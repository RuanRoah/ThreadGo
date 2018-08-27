package com.roah.thread.chapter2.demo;

/**
 * 这个是一个最简单的Demo
 *
 * @author Roah
 * @since 08/13/2018
 */
public class StartAndFinish implements Runnable {

    public static class ThreadClass extends Thread{
        @Override
        public void run() {
            long i = 0;
            while(i<3){
                System.out.println("我是你爷爷");
                i++;
            }
        }
    }

    public static void main(String[] args) {
        StartAndFinish demo = new StartAndFinish();
        System.out.println("-----------");
        demo.run();
        System.out.println("-----------");
        /*new Thread(() -> {
            long i = 0;
            while(i<3){
                System.out.println("我是你爸爸");
                i++;
            }
        }).start();*/
        System.out.println("-----------");
        Thread thread1 = new ThreadClass();
        thread1.start();
        System.out.println("-----------");
        Thread thread2 = new Thread(new StartAndFinish());
        thread2.start();
        thread2.run();
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 3) {
            System.out.println("蛤？");
            i++;
        }
    }
}
