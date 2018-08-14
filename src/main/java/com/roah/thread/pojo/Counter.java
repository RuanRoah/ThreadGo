package com.roah.thread.pojo;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/14/2018
 */

public class Counter {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public synchronized int increment() {
        return ++value;
    }

    public synchronized int decrement() {
        return --value;
    }
}
