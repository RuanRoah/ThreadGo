package com.roah.thread.chapter2.expand;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/27/2018
 */
public class DeamonTest {
    public static class ThreadTest extends Thread{

        @Override
        public void run() {
            while(true){
                System.out.println("蛤");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread threadTest = new ThreadTest();
        threadTest.setDaemon(true);
        threadTest.start();
        //threadTest.setDaemon(true); 进行演示的时候需要对守护线程进行对应切换
        Thread.sleep(2000);
    }

}
