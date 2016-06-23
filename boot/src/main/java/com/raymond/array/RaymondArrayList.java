package com.raymond.array;

/**
 * Created by Raymond Kwong on 6/22/2016.
 * Basics of the ArrayList is that it capacity doubles, when does it double again
 */
public class RaymondArrayList {
    private Object[] array;
    private int count;

    public RaymondArrayList(int size) {
        array = new Object[size];
        count = 0;
    }

    public void add(Object t) {
        if (count >= array.length) {
            increaseSizeOfArray();
        }
        array[count] = t;
        count++;
    }

    //create new array of bigger size and copy current values over
    public void increaseSizeOfArray() {
        Object[] temp = new Object[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            temp[i] = array[i];
        }
        array = temp;
    }

    public Object get(int index) {
        if (index >= array.length) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }

    /*public static void main (String[] args) {
        RaymondArrayList a = new RaymondArrayList(5);
        a.add("15");//0
        a.add("16");//1
        a.add("17");//2
        a.add("18");//3
        a.add("19");//4
        a.add("20");//5
        System.out.println(a.get(4));
    }*/

}
