package com.raymond.queue;

/**
 * Created by Raymond Kwong on 5/25/2016.
 */
public interface RaymondQueue<T> {
    public void add(T obj) throws InterruptedException;
    public T remove() throws InterruptedException;
    public int getSize();
}
