package com.raymond.stack;

import com.raymond.stack.RaymondStack;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondStackProducer<T> implements Runnable{

    private RaymondStack producer;

    public RaymondStackProducer(RaymondStack producer) {
        this.producer = producer;
    }

    @Override
    public void run() {
        try {
            producer.push(""+System.nanoTime());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
