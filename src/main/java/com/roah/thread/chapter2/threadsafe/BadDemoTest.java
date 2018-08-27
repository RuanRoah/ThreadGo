package com.roah.thread.chapter2.threadsafe;

/**
 * TODO: Add Description
 * 不好的synchronized Demo
 * @author Roah
 * @since 08/24/2018
 */
public class BadDemoTest {
    static int test = 0;
    static class TestThread implements Runnable{
        public synchronized void plus(){
            for(int i = 0;i<100000;i++)
            test++;
        }
        @Override
        public void run() {
            plus();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(new TestThread());
        Thread thread2 = new Thread(new TestThread());
        thread1.run();thread2.run();
        thread1.join();thread2.join();
        System.out.println(test);
    }
}
