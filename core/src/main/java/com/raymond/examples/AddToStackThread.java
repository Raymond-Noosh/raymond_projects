package com.raymond.examples;

import java.util.logging.Logger;

/**
 * Created by Raymond Kwong on 3/18/2016.
 */
public class AddToStackThread implements Runnable {

    static final Logger logger = Logger.getLogger(AddToStackThread.class.getName());

    @Override
    public void run() {
        logger.info("Start " + System.currentTimeMillis());
        RaymondStack.add(""+System.currentTimeMillis());
    }
}
