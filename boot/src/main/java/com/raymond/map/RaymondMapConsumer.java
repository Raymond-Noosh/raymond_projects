package com.raymond.map;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondMapConsumer implements Runnable{
    private RaymondMap map;

    public RaymondMapConsumer(RaymondMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        this.map.remove("1");
    }
}
