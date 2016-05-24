package com.raymond.queue;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueueProducer implements Runnable{
    @Override
    public void run() {
        RaymondQueue raymondQueue = RaymondQueue.getInstance();
        raymondQueue.add("1");
        System.out.println(Thread.currentThread().getName());
    }
}
