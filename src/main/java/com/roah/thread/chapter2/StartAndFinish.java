package com.roah.thread.chapter2;

/**
 * 这个是一个最简单的Demo
 *
 * @author Roah
 * @since 08/13/2018
 */
public class StartAndFinish implements Runnable {
    public static void main(String[] args) {
        StartAndFinish demo = new StartAndFinish();
        demo.run();
    }

    @Override
    public void run() {
        int i = 0;
        while (i < 3) {
            System.out.println("蛤？");
            i++;
        }
    }
}
