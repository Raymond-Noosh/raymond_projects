package com.raymond.interviewproblems;

/**
 * Created by Raymond Kwong on 6/15/2016.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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
public class InterviewProblem {

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

    //Write code for an array of numbers, how many are larger than me
    //Example
    //The array is 4 3 8 5 8
    //Start with the simple case and build up
    // start with 2 numbers
    //       4 3
    //what am i doing, I am merely going backward
    //


    //lets use recursion
    public int[] computeSmaller(int[] numbers) {
        int[] result = new int[numbers.length];
        for (int i = numbers.length - 1; i >= 0; i--) {
            int count = 0;
            int a = numbers[i];
            for (int j = 0; j < numbers.length && j < i; j++) {
                int b = numbers[j];
                if (a > b) {
                    count++;
                }
            }
            result[i] = count;
        }
        return result;
    }

    public int[] computeSmallerWithSomeCaching(int[] numbers) {
        int min = numbers[numbers.length - 1];
        int max = numbers[numbers.length - 1];
        HashMap<Integer, Integer> countMap = new HashMap<>(numbers.length);
        int[] result = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int a = numbers[i];
            if (a > max) {
                max = a;
                result[i] = i;
            }
            else if (a < min) {
                min = a;
                result[i] = 0;
            }
            else {
                //
                int nextNumberIamLarger = grabSmaller(numbers, i, min);
                int resultValue = result[nextNumberIamLarger];
                int nextValue = numbers[nextNumberIamLarger];
                if (countMap.containsKey(nextValue)) {
                    Integer value = countMap.get(nextValue);
                    result[i] = value + 1;
                }
                else {
                    result[i] = result[resultValue] + 1;
                }
            }
            if (countMap.containsKey(a)) {
                Integer value = countMap.get(a) + 1;
                countMap.put(a, value);
            }
            else {
                countMap.put(a, 1);
            }
        }
        return result;
    }

    public int grabSmaller(int[] numbers, int start, int min) {
        int s = 0;
        int num = numbers[start];
        for (int i = start-1; i >= 0; i--) {
            int a = numbers[i];
            if (num > a) {
                return i;
            }
            else if (num == a) {
                return i;
            }
        }
        return s;
    }

    //1
    //given a sorted array of negative and positive integers
    //return an array of sorted square roots
    //Implement quick sort after this
    public int[] square(int[] n) {
        int[] temp = new int[n.length];
        int position_index = -1;
        for (int i = 0; i < n.length; i++) {
            int v = n[i];
            if (v < 0) {
                temp[i] = v * v;
            } else {
                temp[i] = v * v;
                if (position_index == -1) {
                    position_index = i;
                }
            }
        }

        int[] result = new int[n.length];
        int i = position_index;
        int j = position_index - 1;
        for (int k = 0; k <result.length; k++) {
            if (i < temp.length && j >= 0) {
                if (temp[i] < temp[j]) {
                    result[k] = temp[i];
                    i++;
                }
                else {
                    result[k] = temp[j];
                    j--;
                }
            }
            else if (i == temp.length && j >= 0) { //j still has some
                result[k] = temp[j];
                j--;
            }
            else {
                result[k] = temp[i];
                i++;
            }

        }
        return result;
    }

    //2
    //Give an array of strings which contains various words
    //Return the unique array of strings
    //"marketing automation services" keep
    //"services automation marketing" remove since not unique
    //

    //3
    //Given an array of numbers, 3 4 8 5 6 2 14 15
    //Find the largest sublist possible and its size
    //Example, 3 4 6 14 15, size 5

    //4
    //Given an array of numbers, 1 3 5 6 7 8 9 2 and 678
    //Return the count of all possible matches within the string
    //1
    //

    public static void main(String[] args) {
        InterviewProblem test = new InterviewProblem();
        //int[] time = new int[]{3,5,6,4,7,9,8,2,4};
        //int[] time = new int[]{9,2,1,2,2,3};
        int[] time = new int[]{-100, -7, -4, 1, 5, 9};
        /*int[] abc = larger(time);
        for (int i = 0; i < abc.length; i++) {
            System.out.print(abc[i] + " ");
        }
        System.out.println("");*/
        /*Long start = System.nanoTime();
        int[] def = test.computeSmaller(time);
        for (int i = 0; i < def.length; i++) {
            System.out.print(def[i] + " ");
        }
        System.out.println(System.nanoTime() - start);

        System.out.println("");

        Long start2 = System.nanoTime();
        int[] ghi = test.computeSmallerWithSomeCaching(time);
        for (int i = 0; i < ghi.length; i++) {
            System.out.print(ghi[i] + " ");
        }
        System.out.println(System.nanoTime() - start2);

        System.out.println("");
        int tt = test.grabSmaller(time, 3, 3);
        System.out.println(tt);*/

        System.out.println("");
        int[] dd = test.square(time);
        for (int i = 0; i < dd.length; i++) {
            System.out.print(dd[i] + " ");
        }
    }
}
