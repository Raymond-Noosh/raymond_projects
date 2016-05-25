package com.raymond.queue;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueueConsumer implements Runnable {
    @Override
    public void run() {
        System.out.println("C-"+Thread.currentThread().getName());
        RaymondQueue raymondQueue = RaymondQueue.getInstance();
        try {
            raymondQueue.remove();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
