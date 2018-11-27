package com.roah.thread.chapter3.core;

import org.junit.jupiter.api.Test;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * 并发锁
 *
 * @author Roah
 * @since 11/26/2018
 */
public class ConcurrentLinkedQueueTest {
    ConcurrentLinkedQueue cq = new ConcurrentLinkedQueue();
    @Test
    public void Test(){
        String test = "test";
        cq.add(test);
        System.out.println(cq.toString());
        cq.poll();
        cq.peek();
        System.out.println(cq);
    }

}