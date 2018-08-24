package com.roah.thread.chapter2.threadsafe;

import java.util.ArrayList;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/22/2018
 */
public class ArrayListDemo {
    static ArrayList<Integer> testArray = new ArrayList<>(10);
    static class testThread implements Runnable{
        @Override
        public void run() {
            for(int i = 0;i<100000;i++){
                testArray.add(i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread test1 = new Thread(new testThread());
        Thread test2 = new Thread(new testThread());
        test1.run();
        test2.run();
        test1.join();
        test2.join();
        System.out.println(testArray.size());
    }
}
