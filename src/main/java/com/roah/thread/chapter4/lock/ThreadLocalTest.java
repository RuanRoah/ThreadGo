package com.roah.thread.chapter4.lock;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 11/27/2018
 */
public class ThreadLocalTest {
    public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    static ThreadLocal<SimpleDateFormat> tl = new ThreadLocal<SimpleDateFormat>();
    public static class ParaseDate implements Runnable {
        static int i = 0;

        public ParaseDate(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                if(tl.get()==null){
                    tl.set(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
                }
                Date t = tl.get().parse("2015-03-29 19:29:" + i);
                System.out.println(i + ": " + t);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Executor threadPoolExecutor = Executors.newFixedThreadPool(10);
        for(int i = 0;i<1000;i++){
            threadPoolExecutor.execute(new ParaseDate(i));
        }
    }
}
