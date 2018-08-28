package com.roah.thread.chapter2.expand;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/28/2018
 */
public class PriorityDemo {
    static volatile int count = 0;
    static class TestThread extends Thread{
        @Override
        public void run() {
            synchronized (PriorityDemo.class){
                for(int i = 0;i<1000000;i++){
                    count++;
                }
            }

            System.out.println(Thread.currentThread().getName()+"OK");
        }
    }

    public static void main(String[] args) {
        Thread t1 = new TestThread();
        t1.setName("a");
        Thread t2 = new TestThread();
        Thread t3 = new TestThread();
        t2.setName("b");
        t3.setName("c");
        t1.setPriority(10);
        t2.setPriority(1);
        t3.setPriority(5);
        t1.start();
        t2.start();
        t3.start();
    }

}
