package com.raymond.future;

import java.util.concurrent.Callable;

/**
 * Created by Raymond Kwong on 6/26/2018.
 */
public class RaymondCallable implements Callable {

    @Override
    public String call() throws Exception {
        return "call";
    }
}
