package com.raymond.examples;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Raymond Kwong on 3/15/2016.
 */
public class Singleton {

    private static Singleton singleton = null;
    private final Lock lock = new ReentrantLock();

    /* A private Constructor prevents any other
     * class from instantiating.
     */
    private Singleton(){ }

    /* Static 'instance' method */
    public static Singleton getInstance( ) {
        if (singleton == null) {
            singleton = new Singleton();
        }
        return singleton;
    }
    /* Other methods protected by singleton-ness */
    protected void demoLocking( ) {
        lock.lock();
        try {
            System.out.println("demoMethod for singleton");

        }
        finally {
            lock.unlock();
        }
    }
}