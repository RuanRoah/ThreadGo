/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.roah.thread.chapter4.lock;

import com.roah.thread.chapter2.demo.JoinTest;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author ruanlaohan
 */
public class AtomicIntegerTest {
    public static AtomicInteger i = new AtomicInteger(0);
    public static class AddThread implements Runnable{
       
        @Override
        public void run() {
            for(int j = 0;j<10000;j++){
                i.incrementAndGet();
            }
        
        }
        
    }
    public static void main(String[] args) throws InterruptedException {
        Thread[] thread = new Thread[20000];
        AddThread addThread = new AddThread();
        System.out.println(System.currentTimeMillis()+":"+i);
        for (int j = 0; j < 10000; j++) {
            thread[j] = new Thread(new AddThread());
        }
        for (int j = 0; j < 10000; j++) {
            thread[j].start();
        }
        for (int j = 0; j < 10000; j++) {
            thread[j].join();
        }
    }
    
}
