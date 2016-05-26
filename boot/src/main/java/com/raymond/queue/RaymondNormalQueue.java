package com.raymond.queue;

import java.util.*;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondNormalQueue<T> implements RaymondQueue {
    private static volatile RaymondNormalQueue raymondNormalQueue;
    private final int MAX_SIZE = 10;
    private Queue<T> queue = new LinkedList<>();

    public static RaymondNormalQueue getInstance() {
        if (raymondNormalQueue == null) {
            synchronized (RaymondNormalQueue.class) {
                if (raymondNormalQueue == null) {
                    raymondNormalQueue = new RaymondNormalQueue();
                }
            }
        }
        return raymondNormalQueue;
    }

    public synchronized void add(Object obj) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            wait();
        }
        notifyAll();
        queue.add((T) obj);
    }

    public synchronized T remove() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        notifyAll();
        return queue.remove();
    }

    @Override
    public int getSize() {
        System.out.println(queue.size());
        return queue.size();
    }

    public Queue<T> getQueue() {
        return queue;
    }

    /*public static void main(String args[]) {
        new Thread(new RaymondQueueProducer()).start();//1
        new Thread(new RaymondQueueProducer()).start();//1
        new Thread(new RaymondQueueProducer()).start();//1
        new Thread(new RaymondQueueProducer()).start();//1
        new Thread(new RaymondQueueProducer()).start();//1
        new Thread(new RaymondQueueProducer()).start();//2
        new Thread(new RaymondQueueConsumer()).start();//1
        new Thread(new RaymondQueueProducer()).start();//2
        new Thread(new RaymondQueueProducer()).start();//3
        new Thread(new RaymondQueueConsumer()).start();//2
        new Thread(new RaymondQueueProducer()).start();//3
        new Thread(new RaymondQueueProducer()).start();//4
        new Thread(new RaymondQueueProducer()).start();//5
        new Thread(new RaymondQueueProducer()).start();//6

        ThreadInfo[] infos = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);
        for (int i = 0; i < infos.length; i++) {
            System.out.println("Waiting Threads -" + infos[i].getWaitedCount());
        }
    }*/

}
