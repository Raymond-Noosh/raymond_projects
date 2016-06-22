package com.raymond.hashtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Kwong on 6/21/2016.
 */
public class RaymondHashtable<T> {

    public int size = 33;

    private List<T>[] table;

    public RaymondHashtable() {
        table = new ArrayList[size];
    }

    public void insert(T value) {
        int index = getHashCode(value);
        List<T> subList = table[index];
        if (subList == null) {
            subList = new ArrayList<T>();
        }
        subList.add(value);
        table[index] = subList;
    }

    public T get(T value) {
        List<T> subList = table[getHashCode(value)];
        if (subList != null) {
            for (T s : subList) {
                if (s.equals(value)) {
                    return s;
                }
            }
        }
        return null;
    }

    public int getHashCode(T key) {
        return key.hashCode() % size;
    }

    public static void main(String args[]) {
        RaymondHashtable<String> hash = new RaymondHashtable<String>();
        hash.insert("abc");
        System.out.println(hash.get("ddd"));
    }

}
