package com.roah.thread.chapter1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Demo1
 *
 * @author Roah
 * @since 08/06/2018
 */
public class Test1 {
    Logger logger = LoggerFactory.getLogger(Test1.class);
    public static void main(String[] args) {
        TestService testService = new TestService();
        TestTwoService testTwoService = new TestTwoService();
        testService.run();
        testTwoService.start();
    }
}
