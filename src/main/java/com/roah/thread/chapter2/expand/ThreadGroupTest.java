package com.roah.thread.chapter2.expand;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/27/2018
 */
public class ThreadGroupTest implements Runnable{
    static java.lang.ThreadGroup threadGroup = new java.lang.ThreadGroup("printGroup");
    static Thread t1 = new Thread(threadGroup,new ThreadGroupTest(),"T1");
    static Thread t2 = new Thread(threadGroup,new ThreadGroupTest(),"T2");
    @Override
    public void run() {
        String threadName = Thread.currentThread().getThreadGroup().getName()+"-"+Thread.currentThread().getName();
        while(true){
            System.out.println("线程"+threadName+"执行");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        t1.start();
        t2.start();
        System.out.println(threadGroup.activeCount());
        threadGroup.list();
    }
}
