package com.raymond.queue;

import com.raymond.threads.RaymondRunnable;

import java.util.*;

/**
 * Created by Raymond Kwong on 5/23/2016.
 */
public class RaymondQueue {
    private static volatile RaymondQueue raymondQueue;

    private static volatile int queueSize = 0;
    private static final int maxSize = 5;
    private static Queue<String> queue = new PriorityQueue<>(maxSize);


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

    public static void add(String str) {
        /*while (queue.p) {

        }*/


        if (queueSize < maxSize) {
            synchronized (RaymondQueue.class) {
                queue.add(str);
                queueSize++;
            }
        }
        else {
            //Thread.currentThread()
        }

    }

    public static String remove() {
        if (queueSize > 0) {
            synchronized (RaymondQueue.class) {
                String str = queue.remove();
                queueSize--;
                return str;
            }
        }
        return null;
    }

    public static void main(String args[]) {
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

        try {
            Thread.sleep(1000L);
            RaymondQueue qq = RaymondQueue.getInstance();
            System.out.println(qq.queue.size());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        /*Iterator iter = qq.queue.iterator();
        while (iter.hasNext()) {
            System.out.println("A");
            //System.out.println((String) iter.next());
        }*/

    }

}
