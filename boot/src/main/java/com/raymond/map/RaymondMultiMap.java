package com.raymond.map;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

/**
 * Created by Raymond Kwong on 5/29/2016.
 */
public class RaymondMultiMap<T, K> implements RaymondM<T, K> {

    private List<RaymondMultiEntry<T, ArrayList<K>>> map = new ArrayList<>();

    public RaymondMultiMap() {
    }

    public synchronized void put(T key, K value) {
        boolean insert = true;
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getKey().equals(key)) {
                ArrayList list = map.get(i).getValues();
                list.add(value);
                insert = false;
            }
        }
        if (insert) {
            ArrayList<K> values = new ArrayList<K>();
            values.add(value);
            RaymondMultiEntry entry = new RaymondMultiEntry(key, values);
            map.add(entry);
        }
    }

    public synchronized ArrayList<K> get(T key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getKey().equals(key)) {
                return map.get(i).getValues();
            }
        }
        return null;
    }

    public synchronized void remove(T key) {
        for (int i = 0; i < map.size(); i++) {
            if (map.get(i).getKey().equals(key)) {
                map.remove(i);
            }
        }
    }

    public synchronized int getSize() {
        return map.size();
    }

    public synchronized List<RaymondMultiEntry<T, ArrayList<K>>> getMap() {
        return map;
    }

    public static void main(String args[]) {
        RaymondMultiMap m = new RaymondMultiMap();

        int i = 5;
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

        ArrayList<RaymondMultiEntry> mapList = (ArrayList<RaymondMultiEntry>) m.getMap();
        for (RaymondMultiEntry entry : mapList) {
            ArrayList list = (ArrayList) entry.getValues();
            Iterator iterator = list.iterator();
            while (iterator.hasNext()) {
                String a = (String) iterator.next();
                System.out.println(a);
            }
        }
        System.out.println("Size=" + m.getSize());

    }
}
