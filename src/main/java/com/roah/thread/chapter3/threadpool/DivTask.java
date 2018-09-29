package com.roah.thread.chapter3.threadpool;

import java.util.concurrent.*;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 09/29/2018
 */
public class DivTask implements Runnable {
    int a,b;

    public DivTask(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        double res = a/b;
        System.out.println(res);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ThreadPoolExecutor test = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 0L, TimeUnit.MILLISECONDS, new SynchronousQueue<>());
        for(int i = 0;i<5;i++){
            //test.submit(new DivTask(100,i));
            //Future future = test.submit(new DivTask(100,i));
            //future.get();
            test.execute(new DivTask(100,i));
        }

    }
}
