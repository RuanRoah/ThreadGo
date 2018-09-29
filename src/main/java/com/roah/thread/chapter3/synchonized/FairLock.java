package com.roah.thread.chapter3.synchonized;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Roah on 2018/9/29.
 */
public class FairLock implements Runnable {

    public static ReentrantLock fairLock = new ReentrantLock(true);
    //public static ReentrantLock unfairLock = new ReentrantLock();

    @Override
    public void run() {
        while (true) {
            try {
                fairLock.lock();
                // unfairLock.lock();
                System.out.println(Thread.currentThread().getName() + "�����");
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

        thread1.start();
        thread2.start();
        thread3.start();
    }

}
