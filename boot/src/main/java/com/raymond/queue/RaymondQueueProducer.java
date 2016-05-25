package com.raymond.queue;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueueProducer implements Runnable{
    @Override
    public void run() {
        System.out.println("P-"+Thread.currentThread().getName());
        RaymondQueue raymondQueue = RaymondQueue.getInstance();
        try {
            raymondQueue.add("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
