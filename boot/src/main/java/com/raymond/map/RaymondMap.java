package com.raymond.map;

import com.raymond.stack.RaymondStack;
import com.raymond.stack.RaymondStackConsumer;
import com.raymond.stack.RaymondStackProducer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Raymond Kwong on 5/26/2016.
 */
public class RaymondMap<T, K> {
    private int size;
    private RaymondEntry[] map;

    public RaymondMap() {
        this.map = new RaymondEntry[5];
        this.size = 0;
    }

    public synchronized void put(T key, K value) {
        boolean replaced = true;
        for (int i = 0; i < this.size; i++) {
            if (map[i].getKey().equals(key)) {
                map[i] = new RaymondEntry(key, value);
                replaced = false;
            }
        }
        if (replaced) {
            RaymondEntry entry = new RaymondEntry(key, value);
            ensureCapacity();
            map[this.size] = entry;
            this.size++;
        }
    }

    public synchronized K get(T key) {
        for (int i = 0; i < this.size; i++) {
            if (map[i].getKey().equals(key)) {
                return (K) map[i].getValue();
            }
        }
        return null;
    }

    public synchronized void remove(T key) {
        for (int i = 0; i < this.size; i++) {
            if (map[i].getKey().equals(key)) {
                this.size--;
                condenseArray(i);
            }
        }
    }

    public RaymondEntry[] getMap() {
        return map;
    }

    public int getSize() {
        return size;
    }

    private synchronized void ensureCapacity() {
        int currentCapacity = this.map.length;
        if (this.size == currentCapacity) {
            this.map = Arrays.copyOf(this.map, currentCapacity * 2);
        }
    }

    private synchronized void condenseArray(int start) {
        for (int i = start; i < this.size; i++) {
            this.map[i] = this.map[i + 1];
        }
        this.map[this.map.length-1]=null;
    }

    public static void main(String[] args) {
        RaymondMap m = new RaymondMap();
        int i = 2;
        while (i > 0) {
            new Thread(new RaymondMapProducer(m)).start();//1
            i--;
        }

        int j = 3;
        while (j > 0) {
            new Thread(new RaymondMapConsumer(m)).start();//1
            j--;
        }
        try {
            Thread.sleep(5000);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
        RaymondEntry[] e = m.getMap();
        for (int p = 0; p < m.getSize(); p++) {
            System.out.println(e[p].getValue());
        }
        System.out.println("Size=" + m.getSize());
    }

}
