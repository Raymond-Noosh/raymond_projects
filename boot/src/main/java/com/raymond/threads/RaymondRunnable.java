package com.raymond.threads;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Raymond Kwong on 5/20/2016.
 */
public class RaymondRunnable implements Runnable {

    private RaymondSingleton ray;

    public RaymondRunnable() {
    }

    @Override
    public void run() {
        long start = System.nanoTime();
        this.ray = RaymondSingleton.getInstanceFromHelper2();
        long end = System.nanoTime();
        System.out.println("Run-"+Thread.currentThread().getName() + "-"+(end-start)/1000);
    }

    public RaymondSingleton getRay() {
        return this.ray;
    }

    public void setRay(RaymondSingleton ray) {
        this.ray = ray;
    }

    /*public static void main (String[] args) {
        Thread one = new Thread(new RaymondRunnable());
        one.start();
    }*/
}
