package com.raymond.interviewproblems;

/**
 * Created by Raymond Kwong on 6/15/2016.
 */

/**
 * Given a Timeseries that keeps information about
 * Temperature readings for a city,
 * return a Timeseries that tells you,
 * for a given day, how long has its value been the largest running value.
   eg: For temperature readings [3,5,6,2,1,4,6,9] , the transformed timeseries would be [1,2,3,1,1,3,7,8]
 */

//[3,5,6,2,1,4,6,9]
//[1,2,3,1,1,3,7,8]

//how many before me have been larger

public class C3IOTProblem {

    public static int[] timeseries(int[] temp) {
        int[] response = new int[temp.length]; //1, 2, 3, 1, 1
        int largerCount = 1; //1,2,3
        int max = temp[0]; //3,5,6
        for (int i = 0; i < temp.length; i++) { //3,5,6,2,1,4
            if (temp[i] > max) {
                largerCount++;
                response[i] = largerCount;
                max = temp[i];
            }
            else {
                largerCount = 1;
                response[i] = largerCount;
            }
        }
        return response;
    }

    /*public static void main (String[] args) {
        int[] time = {3,5,6,2,1,4,6,9};
        int[] abc = timeseries(time);
        System.out.println(abc);
    }*/
}
