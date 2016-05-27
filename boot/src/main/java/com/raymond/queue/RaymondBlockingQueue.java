package com.raymond.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by Raymond Kwong on 5/25/2016.
 */
public class RaymondBlockingQueue<T> implements RaymondQueue {
    private volatile static RaymondBlockingQueue raymondBlockingQueue;
    private final int MAX_SIZE = 10;
    private BlockingQueue<T> blockingQueue = new LinkedBlockingQueue<T>(MAX_SIZE);

    public static RaymondBlockingQueue getInstance() {
        if (raymondBlockingQueue == null) {
            synchronized (RaymondBlockingQueue.class) {
                if (raymondBlockingQueue == null) {
                    raymondBlockingQueue = new RaymondBlockingQueue();
                }
            }
        }
        return raymondBlockingQueue;
    }

    @Override
    public void add(Object obj) throws InterruptedException {
        blockingQueue.put((T) obj);
    }

    @Override
    public T remove() throws InterruptedException {
        return blockingQueue.take();
    }

    @Override
    public int getSize() {
        System.out.println(blockingQueue.size());
        return blockingQueue.size();
    }

    public BlockingQueue<T> getBlockingQueue() {
        return blockingQueue;
    }
}
