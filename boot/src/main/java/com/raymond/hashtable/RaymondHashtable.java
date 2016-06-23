package com.raymond.hashtable;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Raymond Kwong on 6/21/2016.
 */
public class RaymondHashTable<T> {

    private int size;
    private List<T>[] table;

    public RaymondHashTable(int size) {
        this.size = size;
        table = new LinkedList[size];
    }

    public synchronized void put(T value) {
        int index = getHashCode(value);
        List<T> subList = table[index];
        if (subList == null) {
            subList = new LinkedList<T>();
        }
        subList.add(value);
        table[index] = subList;
    }

    public synchronized T get(T value) {
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
        return Arrays.hashCode(new Object[]{key}) % this.size;
    }

    public synchronized void printAllAtIndex(int index) {
        List<T> row = table[index];
        if (row != null) {
            row.forEach(System.out::println);
        }
    }

    public static void main(String args[]) {
        RaymondHashTable<String> hash = new RaymondHashTable<String>(31);
        hash.put("abc");
        hash.printAllAtIndex(6);
        System.out.println(hash.get("abc"));
    }

}
