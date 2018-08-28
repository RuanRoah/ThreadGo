package com.roah.thread.chapter2.threadsafe;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/14/2018
 */
public class SupspandGoodDemo{
    static Object object = new Object();
    static volatile boolean supspand = false;
    static class TestThread1 extends Thread{
        @Override
        public void run() {
            while(true){
                synchronized (this){
                    if(supspand){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (object){
                    System.out.println("蛤");
                }
                Thread.yield();
            }
        }
        public void setSupspand(){
            supspand = true;
        }
        public void setResume(){
            supspand = false;
            synchronized (this){
                notify();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
        TestThread1 t1 = new TestThread1();
        t1.start();
        Thread.sleep(3000);
        t1.setSupspand();
        System.out.println("--------挂起---------");
        Thread.sleep(3000);
        System.out.println("-----释放野性之力-----");
        t1.setResume();
    }
}
