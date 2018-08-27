package com.roah.thread.chapter2.demo;

/**
 * Supspand不好的例子
 *
 *
 * @author Roah
 * @since 08/27/2018
 */
public class BadSupspand {
    public static Object u = new Object();
    static TestThread t1 = new TestThread("t1");
    static TestThread t2 = new TestThread("t2");
    static class TestThread extends Thread{
        public TestThread(String name){
            super.setName(name);
        }
        @Override
        public void run() {
            synchronized (u){
                System.out.println("线程"+getName());
                Thread.currentThread().suspend();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        t1.sleep(1000);
        t2.start();
        //This inspection reports where deprecated code is used in the specified inspection scope.
        //官方的解释是这段属于弃用代码
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
        //查看jstack进程号，这个时候t2还是运行的，电脑会很热。
    }
}
