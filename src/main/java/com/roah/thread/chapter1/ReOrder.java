package com.roah.thread.chapter1;

/**
 * 关于重排序的各种猜想
 *
 * @author Roah
 * @since 08/21/2018
 */
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.CountDownLatch;

public class ReOrder {
    static int a = 0;
    static int b = 0;
    static int x = 0;
    static int y = 0;
    static final Set<Map<Integer, Integer>> ans = new HashSet<>(4);
    public void help() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(2);
        Thread threadOne = new Thread(() -> {
            a = 1;
            x = b;
            latch.countDown();
        });

        Thread threadTwo = new Thread(() -> {
            b = 1;
            y = a;
            latch.countDown();
        });
        threadOne.start();
        threadTwo.start();
        latch.await();
        Map<Integer, Integer> map = new HashMap<>();
        map.put(x, y);
        if (!ans.contains(map)) {
            ans.add(map);
        }
    }

    @Test
    public void testReordering() throws InterruptedException {
        for (int i = 0; i < 20000 && ans.size() != 4; i++) {
            help();
            a = x = b = y = 0;
        }
        help();
        System.out.println(ans);
    }
}
