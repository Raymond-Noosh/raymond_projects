package com.raymond.examples;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Raymond Kwong on 3/20/2016.
 */
public class Fibonacci {

    static final Logger logger = Logger.getLogger(Fibonacci.class.getName());



    public static int factorial(int n) {
        //logger.info("" + n);
        if (n == 1) {
            return 1;
        }
        return (n * factorial(n - 1));
        //(3 * (2 * (1)))
    }

    public static int sum(int n) {
        //logger.info("" + n);
        if (n == 1) {
            return n;
        }
        return (n + sum(n - 1));
        // (5 + 4 + 3 + 2 + 1)
    }

    // 1, 1, 2, 3, 5, 8, 13, 21, 34
    public static int fibonacciWhileLoopLimit(int limit) {
        int a = 1;
        int b = 1;
        int sum = 0;
        while (true) {
            if (sum == 0) { // first time
                sum = a; //1
            }
            else { // after
                a = b; //1 1 2 3 5 8 13
                b = sum; //1 2 3 5 8 13 21
                sum = sum + a; //2 3 5 8 13 21 34
                if (sum > limit) {
                    return b;
                }
            }
            //logger.info(""+b);
        }
    }

    // 1, 1, 2, 3, 5, 8, 13, 21, 34
    public static int fibonacciRecursionLimit(int start, int mid, int limit) {//1 1 27
        //logger.info(""+start);
        if (mid > limit) {
            return start;
        }
        return fibonacciRecursionLimit(mid, start + mid, limit);
    }

    //0  1  2  3  4  5  6   7   8   9
    //0, 1, 1, 2, 3, 5, 8, 13, 21, 34
    public static int fibonacciRecursionNth(int start, int mid, int nth) {//1 1 2
        if (nth <= 1) {
            return start;
        }
        return fibonacciRecursionNth(mid, start+mid, nth-1);
    }

    public static int fibonacciRecursionNthLimit(int limit) {//1 1 2
        int i = 1;
        int sum = 0;
        while (true) {
            int beforeMax = fibonacciRecursionNth(1, 1, i);
            if (beforeMax > limit) {
                sum = fibonacciRecursionNth(1, 1, i-1);
                break;
            }
            i++;
        }
        return sum;
    }

    public static int fibonacciRecursionSlowLimit(int limit) {
        int i = 1;
        int sum = 0;
        int previousSum = 0;
        while (true) {
            previousSum = sum;
            sum = fibonacciRecursionSlow(i);
            if (sum > limit) {
                return previousSum;
            }
            i++;
        }
    }

    //Possible classic, but slow
    //grab 5th one
    public static int fibonacciRecursionSlow(int n) { ////fibonacciRecursionSlow(3)
        if (n <= 1) {
            return n;
        }
        else {
            return fibonacciRecursionSlow(n-1) + fibonacciRecursionSlow(n-2);
        }
                //fibonacciRecursionSlow(2)+fibonacciRecursionSlow(1)
        //fibonacciRecursionSlow(1)+fibonacciRecursionSlow(0)             1
            //1 + 0
    }

    public static void main(String[] args){
        int i = factorial(3);
        //logger.info("" + i);

        int s = sum(5);
        //logger.info("" + s);

        int maxFibonacci = 100000000;

        long now = new Date().getTime();
        int fLoop = fibonacciWhileLoopLimit(maxFibonacci);
        logger.info("" + fLoop + " Time:" + (new Date().getTime()-now));

        now = new Date().getTime();
        int fibLimit = fibonacciRecursionLimit(1, 1, maxFibonacci);
        logger.info("" + fibLimit+ " Time:" + (new Date().getTime()-now));

        now = new Date().getTime();
        int fFib2 = fibonacciRecursionNth(1, 1, 5);
        logger.info("" + fFib2+ " Time:" + (new Date().getTime()-now));

        now = new Date().getTime();
        int f2 = fibonacciRecursionNthLimit(maxFibonacci);
        logger.info("" + f2+ " Time:" + (new Date().getTime()-now));

        now = new Date().getTime();
        int f3 = fibonacciRecursionSlowLimit(maxFibonacci);//Slow
        logger.info("" + f3 + " Time:" + (new Date().getTime()-now));
    }
}
