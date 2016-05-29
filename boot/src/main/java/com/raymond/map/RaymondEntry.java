package com.raymond.map;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondEntry<T, K> {
    private T key;
    private K value;

    public RaymondEntry(T key, K value) {
        this.key = key;
        this.value = value;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public K getValue() {
        return value;
    }

    public void setValue(K value) {
        this.value = value;
    }
}
