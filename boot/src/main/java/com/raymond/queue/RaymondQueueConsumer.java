package com.raymond.queue;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueueConsumer implements Runnable {

    private RaymondQueue raymondQueue;

    public RaymondQueueConsumer() {
    }

    public RaymondQueueConsumer(RaymondQueue raymondQueue) {
        this.raymondQueue = raymondQueue;
    }

    @Override
    public void run() {
        System.out.println("C-"+Thread.currentThread().getName());
        try {
            raymondQueue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
