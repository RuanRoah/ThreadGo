package com.roah.thread.chapter2.threadsafe;

/**
 * volatile测试类
 *
 * @author Roah
 * @since 08/21/2018
 */
public class VolatileTest {
    //volatile代表着易变且不稳定，
    public static volatile long test = 0;
    // 当声明volatile变量的值被改变的时候，会通知所有线程
    public static class VolatileDemos implements Runnable{

        @Override
        public void run() {
            for(int i=0;i<100000;i++){
                test++;
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[10];
        for(int i=0;i<10;i++){
           threads[i] = new Thread(new VolatileDemos());
           threads[i].start();
        }
        for(int i=0;i<10;i++){
            threads[i].join();
        }
        System.out.println(test);
    }

}
