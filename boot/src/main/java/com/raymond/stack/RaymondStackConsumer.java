package com.raymond.stack;

import com.raymond.stack.RaymondStack;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondStackConsumer implements Runnable{

    private RaymondStack consumer;

    public RaymondStackConsumer(RaymondStack consumer) {
        this.consumer = consumer;
    }

    @Override
    public void run() {
        try {
            consumer.pop();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
