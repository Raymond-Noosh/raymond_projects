package com.raymond.interviewproblems;

/**
 * Created by Raymond Kwong on 6/15/2016.
 */

import java.util.Arrays;

/**
 * Given a Timeseries that keeps information about
 * Temperature readings for a city,
 * return a Timeseries that tells you,
 * for a given day, how long has its value been the largest running value.
 * eg: For temperature readings [3,5,6,2,1,4,6,9] , the transformed timeseries would be [1,2,3,1,1,3,7,8]
 */

//[3,5,6,2,1,4,6,9]
//[1,2,3,1,1,3,7,8]

//How many number am I great than to the left
public class C3IOTProblem {

    public static int[] larger(int[] temp) {
        int[] response = new int[temp.length];
        if (temp.length == 1) {
            response[0] = 1;
            return response;
        }
        for (int i = temp.length - 1; i >= 0; i--) {//1
            int currentVal = temp[i]; //5
            int larger = 0;
            for (int j = i; j >= 0; j--) {//1, 0
                if (currentVal >= temp[j]) {
                    larger++; //1
                }
                else {
                    break;
                }
            }
            response[i] = larger;
        }
        return response;
    }

    public static void main(String[] args) {
        int[] time = new int[]{3,5,6,2,1,4,6,9};
        int[] abc = larger(time);
        for (int i = 0; i < abc.length; i++) {
            System.out.print(abc[i] + " ");
        }
    }
}
