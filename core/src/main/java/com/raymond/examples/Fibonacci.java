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
    public static int fibonacciWhileLoopLimit(int end) {
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
                if (sum > end) {
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

    public static int fibonacciRecursion2Limit(int limit) {
        int i = 1;
        int sum = 0;
        int previousSum = 0;
        while (true) {
            previousSum = sum;
            sum = fib(i);
            if (sum > limit) {
                return previousSum;
            }
            i++;
        }

    }

    public static int fib(int n) {
        if (n <= 1) {
            return n;
        }
        else {
            return fib(n-1) + fib(n-2);
        }
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
        int fRecursion = fibonacciRecursionLimit(1, 1, maxFibonacci);
        logger.info("" + fRecursion+ " Time:" + (new Date().getTime()-now));

        now = new Date().getTime();
        int f3 = fibonacciRecursion2Limit(maxFibonacci);//Slow
        logger.info("" + f3 + " Time:" + (new Date().getTime()-now));
    }
}
