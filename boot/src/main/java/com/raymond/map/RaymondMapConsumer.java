package com.raymond.map;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondMapConsumer implements Runnable{
    private RaymondM map;

    public RaymondMapConsumer(RaymondM map) {
        this.map = map;
    }

    @Override
    public void run() {
        this.map.remove("1");
    }
}
