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
    static String a1 = "老大";
    static String a2 = "老二";
    static String b1 = "老三";
    static String b2 = "老四";
    public static void main(String[] args) {
        /*new Thread(() -> {
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
        }).start();*/
        System.out.println("---------");
    }
}
