package com.roah.thread.chapter3.synchonized;

import java.util.concurrent.locks.ReentrantLock;

import static java.lang.Thread.MAX_PRIORITY;
import static java.lang.Thread.MIN_PRIORITY;

/**
 * Created by Roah on 2018/9/29.
 */
public class FairLock implements Runnable {

    public  ReentrantLock fairLock = new ReentrantLock();
    //public static ReentrantLock unfairLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                // unfairLock.lock();
                System.out.println(Thread.currentThread().getName());
            } finally {
                fairLock.unlock();
                // unfairLock.unlock();
            }
        }
    }

    /**
     * ��ƽ����һ���ص���:���������������,ֻҪ�Ŷ����ն���õ���Դ.
     * <p/>
     * ����ʵ�ֹ�ƽ��Ҫ��ϵͳά��һ���������,��˹�ƽ����ʵ�ֳɱ��ϸ�,������Ե���.
     *
     * @param args
     */
    public static void main(String args[]) {
        FairLock r1 = new FairLock();
        Thread thread1 = new Thread(r1, "Thread_t1");
        Thread thread2 = new Thread(r1, "Thread_t2");
        Thread thread3 = new Thread(r1, "Thread_t3");
        Thread thread4 = new Thread(r1, "Thread_t4");
        Thread thread5 = new Thread(r1, "Thread_t5");
        Thread thread6 = new Thread(r1, "Thread_t6");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();

    }

}
