package com.raymond.examples;

/**
 * Created by Raymond Kwong on 3/18/2016.
 */
public class RemoveFromStackThread implements Runnable {

    @Override
    public void run() {
        RaymondStack.remove();
    }
}
