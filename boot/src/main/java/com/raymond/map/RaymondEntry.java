package com.raymond.map;

/**
 * Created by Raymond Kwong on 5/28/2016.
 */
public class RaymondEntry<T, K> {
    private T key;
    private K value;
    private RaymondEntry next;

    public RaymondEntry(T key, K value, RaymondEntry next) {
        this.key = key;
        this.value = value;
        this.next = next;
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

    public RaymondEntry getNext() {
        return next;
    }

    public void setNext(RaymondEntry next) {
        this.next = next;
    }
}
