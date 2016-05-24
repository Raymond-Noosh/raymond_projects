package com.raymond.queue;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueueConsumer implements Runnable {
    @Override
    public void run() {
        RaymondQueue raymondQueue = RaymondQueue.getInstance();
        raymondQueue.remove();
        System.out.println(Thread.currentThread().getName());
    }
}
