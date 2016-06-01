package com.raymond.recursion;

/**
 * Created by Raymond Kwong on 5/29/2016.
 */
public class Fib {
    //0, 1, 2, 3, 4, 5, 6, 7, 8, 9
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    public static int classicFib(int i) {
        if (i == 0) {
            return 0;
        }
        if (i < 0) {
            return 1;
        }
        return classicFib(i - 1) + classicFib(i - 2);
    }

    public static int newFib(int i) {
        return newFibHelper(0, 1, i);
    }

    //                    0, 1, 3
    //                    1, 1, 2
    //                    1, 2, 1
    //                    2, 3, 0

    public static int newFibHelper(int temp, int sum, int i){
        if (i == 0) {
            return temp;
        }
        return newFibHelper(sum, temp + sum, i - 1);
    }


    /*public static void main(String[] args) {
        long start = System.nanoTime();
        int result = newFib(25);
        long end = System.nanoTime();
        System.out.println(result);
        System.out.println(end-start+" nanoseconds");

    }*/
}
