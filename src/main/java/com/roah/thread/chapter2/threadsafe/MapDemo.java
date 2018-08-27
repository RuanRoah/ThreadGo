package com.roah.thread.chapter2.threadsafe;

import java.util.HashMap;

/**
 * 蜜汁HashMap
 *
 * @author Roah
 * @since 08/21/2018
 */
public class MapDemo {
    static HashMap<String,String> mapTest = new HashMap<String,String>();

    static class AddThreadTest implements Runnable{
        int start = 0;
        public AddThreadTest(int start) {
            this.start = start;
        }

        @Override
        public void run(){
            for(int i = start;i<100000;i+=1){
                mapTest.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread test1 = new Thread(new MapDemo.AddThreadTest(0));
        Thread test2 = new Thread(new MapDemo.AddThreadTest(1));
        test1.run();
        test2.run();
        test1.join();
        test2.join();
        System.out.println(mapTest.size());
        //System.out.println(mapTest.toString());
    }
}
