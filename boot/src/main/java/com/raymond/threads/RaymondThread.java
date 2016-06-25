package com.raymond.threads;

/**
 * Created by Raymond Kwong on 6/24/2016.
 */
public class RaymondThread extends Thread {
    @Override
    public void run() {
        System.out.println("I am running");
        super.run();
    }

    /*public static void main(String[] args) {
        RaymondThread thread = new RaymondThread();
        thread.run();
    }*/
}
