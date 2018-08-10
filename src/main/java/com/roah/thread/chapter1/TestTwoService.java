package com.roah.thread.chapter1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * TODO: Add Description
 *
 * @author Roah
 * @since 08/06/2018
 */
public class TestTwoService extends Thread{
   Logger logger = LoggerFactory.getLogger(TestTwoService.class);
   @Override
   public void run(){
       logger.info("我是你爸爸");
   }
}
