package com.roah.thread.chapter2.jstack;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/22/2018
 */
public class RunnableTest implements Runnable{

    public static void main(String[] args) {
        while(true){
            System.out.println("蛤");
        }
    }

    @Override
    public void run() {
        Thread thread = new Thread(new RunnableTest());
        thread.run();
    }
}
