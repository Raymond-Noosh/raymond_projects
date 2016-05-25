package com.raymond.queue;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.util.*;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueue<T> {
    private static volatile RaymondQueue raymondQueue;
    private final int MAX_SIZE = 10;
    private Queue<T> queue = new LinkedList<>();

    public static RaymondQueue getInstance() {
        if (raymondQueue == null) {
            synchronized (RaymondQueue.class) {
                if (raymondQueue == null) {
                    raymondQueue = new RaymondQueue();
                }
            }
        }
        return raymondQueue;
    }

    public synchronized void add(T str) throws InterruptedException {
        while (queue.size() == MAX_SIZE) {
            wait();
        }
        notifyAll();
        queue.add(str);
    }

    public synchronized T remove() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        notifyAll();
        return queue.remove();
    }

    public synchronized void P() {
        System.out.println("P");
    }

    public synchronized void C() {
        System.out.println("C");
    }

    public void startProducer() {
        new Thread(new RaymondQueueProducer()).start();//1
    }

    public void startConsumer() {
        new Thread(new RaymondQueueConsumer()).start();//1
    }

    public void checkWaitingThreads() {
        ThreadInfo[] infos = ManagementFactory.getThreadMXBean().dumpAllThreads(true, true);
        for (int i = 0; i < infos.length; i++) {
            System.out.println("Waiting Threads -" + infos[i].getWaitedCount());
        }
        System.out.println(queue.size());
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
