package com.raymond.map;

import java.util.Objects;

/**
 * Created by Raymond Kwong on 5/26/2016.
 */
public class RaymondMap<T, K> implements RaymondM<T, K>{
    private int size;
    private RaymondEntry[] map;

    public RaymondMap() {
        this.map = new RaymondEntry[10];
        this.size = 0;
    }

    public synchronized void put(T key, K value) {
        int hash = hash(key);
        RaymondEntry node = map[hash];
        if (node == null) { //empty
            RaymondEntry firstEntry = new RaymondEntry(key, value, null);
            map[hash] = firstEntry;
            this.size++;
        }
        else {
            //Need to also check if the array already contains this value and if it does, overwrite it
            while (node.getNext() != null) {
                if (node.getKey().equals(key)) {
                    node.setValue(value);//overwrite
                    return;
                }
                node = node.getNext();
            }
            if (node.getKey().equals(key)) {
                node.setValue(value);//overwrite
            }
            else {
                RaymondEntry newEntry = new RaymondEntry(key, value, node);
                map[hash] = newEntry;
                this.size++;
            }
        }
    }

    public synchronized K get(T key) {
        int hash = hash(key);
        RaymondEntry<T, K> entry = map[hash];
        if (entry == null) {
            return null;
        }
        else {
            while (entry.getNext() != null) {
                if (Objects.equals(entry.getKey(), key)) {
                    return entry.getValue();
                }
                entry = entry.getNext();
            }
            if (Objects.equals(entry.getKey(), key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public synchronized void remove(T key) {
        int hash = hash(key);
        RaymondEntry node = map[hash];
        RaymondEntry previousNode = node;
        if (node != null) {
            if (node.getNext() == null) {
                map[hash] = null;
                this.size--;
                return;
            }
            while (node.getNext() != null) {
                if (node.getKey().equals(key)) {
                    //need some linkedlist logic
                    //needs to cover removal at head
                    //removal in the middle
                    //removal at the end
                    if (node == previousNode) {
                        map[hash] = node.getNext();
                        this.size--;
                        return;
                    }
                    node = node.getNext();
                    previousNode.setNext(node);
                    this.size--;
                    return;
                }
                previousNode = node;
                node = node.getNext();
            }
            if (node.getKey().equals(key)) { //at tail
                previousNode.setNext(node.getNext());
                this.size--;
                return;
            }
        }
    }

    public RaymondEntry[] getMap() {
        return map;
    }

    public int getSize() {
        return size;
    }

    public int hash(T key) {
        int h = Objects.hashCode(key);
        if (h < 0) {
            h = h * -1;
        }
        int modulus = h % 10; //Take last digit, assume capacity then is max 10, 0-9
        return modulus;
    }

    public static void main(String[] args) {

        RaymondMap<String, String> m = new RaymondMap();
        m.put("Hi", "No");
        m.put("b", "Blue");
        m.put("g", "Green");
        m.put("r", "Red");
        m.put("Eye", "Black");
        m.put("race", "indian");
        m.put("race", "joe");
        m.put("lips", "red");
        m.put("finder", "ring");
        m.put("ear", "rings");
        m.put("teeth", "white");
        m.put("arm", "tattoo");
        m.put("glue", "stick");
        m.put("table", "wood");
        m.put("bag", "white");
        m.put("cup", "yellow");
        m.put("speaker", "black");
        m.put("phone", "off");
        m.put("Eye", "Yes");

        m.remove("arm");
        m.remove("race");
        m.put("lips", "orange");
        String dd = m.get("lips");
        String arm = m.get("arm");
        System.out.println(dd);
        System.out.println(arm);
        /*int i = 2;
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
        System.out.println("Size=" + m.getSize());*/
    }

}
