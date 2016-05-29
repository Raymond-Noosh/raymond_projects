package com.raymond.map;

import java.util.Random;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondMapProducer implements Runnable {

    private RaymondMap map;

    public RaymondMapProducer(RaymondMap map) {
        this.map = map;
    }

    @Override
    public void run() {
        Random r = new Random();
        int random = r.nextInt(Integer.MAX_VALUE);
        this.map.put(""+random, ""+random);
    }
}
