package com.raymond.examples;

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

    // 1, 1, 2, 3, 5, 8, 13, 21
    public static int fib(int start, int end) {
        logger.info(""+start);
        if (start >= end) {
            return start;
        }
        int sum = (start + fib(start + 1, end));
        return sum;
        //1 + 2 3 4 5
    }

    //n=1 i=0
    //n=n+i = 1 i=0
    //n=n+i = 2 i=1
    //n=n+i = 4 i=2

    // 1, 1, 2, 3, 5, 8, 13, 21
    public static void fibloop(int end) {
        int a = 0;
        int b = 1;
        int sum = 0;
        for (int i = 1; i < end; i++) {
            a = a + (a + 1);
        }
    }

    public static void main(String[] args){
        int i = factorial(3);
        //logger.info("" + i);

        int s = sum(5);
        //logger.info("" + s);

        int f = fib(1, 5);
        //logger.info("" + f);
    }
}
