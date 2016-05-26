package com.raymond.queue;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueueProducer implements Runnable{

    private RaymondQueue raymondQueue;

    public RaymondQueueProducer() {
    }

    public RaymondQueueProducer(RaymondQueue raymondQueue) {
        this.raymondQueue = raymondQueue;
    }

    @Override
    public void run() {
        System.out.println("P-"+Thread.currentThread().getName());
        try {
            raymondQueue.add("1");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
