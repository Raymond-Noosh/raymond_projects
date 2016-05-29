package com.raymond.map;

/**
 * Created by Raymond Kwong on 5/29/2016.
 */
public class RaymondMultiEntry<T, ArrayList> {
    private T key;
    private ArrayList values;

    public RaymondMultiEntry(T key, ArrayList values) {
        this.key = key;
        this.values = values;
    }

    public T getKey() {
        return key;
    }

    public void setKey(T key) {
        this.key = key;
    }

    public ArrayList getValues() {
        return values;
    }

    public void setValues(ArrayList values) {
        this.values = values;
    }
}
