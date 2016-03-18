package com.raymond.service.impl;

import com.raymond.service.RaymondService;

import java.util.logging.Logger;

/**
 * Created by Raymond-Home on 3/16/2016.
 */
public class RaymondServiceImpl implements RaymondService {

    static final Logger log = Logger.getLogger(RaymondServiceImpl.class.getName());

    public void test() {
        log.info("bs");
    }

    public static void main( String[] args )
    {
        RaymondServiceImpl s = new RaymondServiceImpl();
        s.test();

    }
}
