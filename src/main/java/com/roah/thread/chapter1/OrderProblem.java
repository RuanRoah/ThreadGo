package com.roah.thread.chapter1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/09/2018
 */

public class OrderProblem {
    private static final Logger logger = LoggerFactory.getLogger(OrderProblem.class);
    static String a1 = "A : x = x + 1";
    static String a2 = "A : x = x - 1";
    static String b1 = "B : x = x * 2";
    static String b2 = "B : x = x / 2";
    public static void main(String[] args) {
        //不采取有序性措施,也没有发生有序性问题.....
        logger.info("不采取措施：单线程串行，视为有序；多线程交叉串行，视为无序。");
        new Thread(() -> {
            System.out.println(a1);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(a2);
        }).start();
        new Thread(() -> {
            System.out.println(b1);
            System.out.println(b2);
        }).start();
        System.out.println("---------");
    }
}
