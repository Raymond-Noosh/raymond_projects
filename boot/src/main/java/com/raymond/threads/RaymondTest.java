package com.raymond.threads;

/**
 * Created by Raymond Kwong on 5/20/2016.
 */
public class RaymondTest {

    public RaymondTest() {
    }

    public static void main(String args[]) {
        new Thread(new RaymondRunnable()).start();

        new Thread(new RaymondRunnable()).start();
    }

}
