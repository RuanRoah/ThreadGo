package com.roah.thread.chapter3.threadpool;

import java.util.concurrent.*;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 09/29/2018
 */
public class TraceThreadPoolExcutor extends ThreadPoolExecutor {
    public TraceThreadPoolExcutor(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
        super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
    }

    public void execute(Runnable task) {
        super.execute(wrap(task, clientTrace(), Thread.currentThread().getName()));
    }

    private Runnable wrap(final Runnable task, final Exception clientTrace, String name) {
        return new Runnable() {
            @Override
            public void run() {
                try {
                    task.run();
                } catch (Exception e) {
                    clientTrace.printStackTrace();
                    throw e;
                }
            }
        };
    }

    private Exception clientTrace() {
        return new Exception("Client stack trace");
    }
}
