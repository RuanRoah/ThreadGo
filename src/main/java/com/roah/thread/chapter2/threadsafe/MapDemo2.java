package com.roah.thread.chapter2.threadsafe;

/**
 * HashMap线程不安全的例子
 *
 * @author Roah
 * @since 08/27/2018
 */
import java.util.HashMap;

public class MapDemo2 {
    public static final HashMap<String, String> hashMap=new HashMap<String, String>();
    public static void main(String[] args) {

        Thread t1 = new Thread(){

            @Override
            public void run() {
                for (int i = 0; i < 25; i++) {
                    hashMap.put(i+"", i+"");
                }
            }
        };

        Thread t2 = new Thread(){

            @Override
            public void run() {
                for (int i = 25; i < 50; i++) {
                    hashMap.put(i+"", i+"");
                }
            }

        };

        t1.start();
        t2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 50; i++) {
            System.out.println(i+"/"+hashMap.get(i+""));
        }
    }

}
