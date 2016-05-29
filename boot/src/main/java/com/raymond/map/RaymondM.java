package com.raymond.map;

/**
 * Created by Raymond Kwong on 5/29/2016.
 */
public interface RaymondM<T, K> {
    public void put(T key, K value);
    public void remove(T key);
    public int getSize();
}
