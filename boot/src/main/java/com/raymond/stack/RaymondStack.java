package com.raymond.stack;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Raymond Kwong on 5/26/2016.
 */
public class RaymondStack<T> {
    private final int CAPACITY;
    private List stack = new LinkedList<T>();

    public RaymondStack (int capacity) {
        this.CAPACITY = capacity;
    }

    public synchronized void push(T obj) throws InterruptedException{
        while (stack.size() == CAPACITY) {
            wait();
        }
        notifyAll();
        stack.add(obj);
    }

    public synchronized T pop() throws InterruptedException {
        while (stack.size() == 0) {
            wait();
        }
        notifyAll();
        return (T) stack.remove(stack.size()-1);
    }

    public int getSize() {
        return stack.size();
    }

    public static void main (String args[]) {
        RaymondStack q = new RaymondStack<String>(10);
        int i = 20;
        while (i > 0) {
            new Thread(new RaymondStackProducer(q)).start();//1
            i--;
        }

        int j = 30;
        while (j > 0) {
            new Thread(new RaymondStackConsumer(q)).start();//1
            j--;
        }
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("QueueSize=" + q.getSize());
    }
}
