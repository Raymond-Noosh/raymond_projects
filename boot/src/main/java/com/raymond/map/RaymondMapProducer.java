package com.raymond.map;

import java.util.Random;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondMapProducer implements Runnable {

    private RaymondM map;

    public RaymondMapProducer(RaymondM map) {
        this.map = map;
    }

    @Override
    public void run() {
        map.put("cup", "yellow");
        map.put("speaker", "black");
        map.put("phone", "off");
        map.put("Eye", "Yes");
    }
}
