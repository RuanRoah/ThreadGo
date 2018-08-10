package com.roah.thread.enums;

import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/06/2018
 */
public enum State {
    NEW("1","NEW"),
    RUNNABLE("2","RUNNABLE"),
    BLOCKED("3","BLOCKED"),
    WAITING("4","WAITING"),
    TIME_WAITING("5","TIME_WAITING");
    State(String s, String aNew) {

    }
}
