package com.raymond.examples;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Raymond Kwong on 3/16/2016.
 */
public class RaymondStack {
    private static final Integer MAX_SIZE = 10;
    private static ArrayList<String> list = new ArrayList<>(MAX_SIZE);

    public static void add(String str) {
        synchronized (list) {
            System.out.println(Thread.currentThread().getName() +  " " + "Current Size from Add " + list.size());
            if (isFull()) {
                try {
                    System.out.println(Thread.currentThread().getName() + " has entered wait");
                    list.wait();
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(str);
            try {
                list.wait(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static String remove() {
        synchronized (list) {
            System.out.println(Thread.currentThread().getName() +  " " + "Current Size from Remove " + list.size());
            if (list.size() > 0) {
                String str = list.remove(list.size() - 1);
                list.notifyAll();
                return str;
            } else {
                return null;
            }
        }
    }

    public static boolean isFull() {
        return (list.size() == MAX_SIZE);
    }

    public static int getSize() {
        return list.size();
    }

    public static List getList() {
        return list;
    }

    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

}
