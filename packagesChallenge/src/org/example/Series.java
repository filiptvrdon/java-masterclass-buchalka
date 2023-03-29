package org.example;

import java.util.Arrays;

public class Series {
    public static int getSum(int n) {
        if (n == 0){
            return 0;
        }
       return (n * (n+1))/2;
    }

    public static long getFactorial(int n){
        if (n == 0){
            return 0;
        }

        long factorial = 1;

        for (int i = 1; i <= n; i++){
            factorial = factorial * i;
        }
        return factorial;
    }

    public static int getFibonacci(int n){
        // System.out.println(n);

        int[] fibonnaciArray = new int[n+1];

        int firstNumber = 0;
        int secondNumber = 1;
        int nextNumber;

        for (int i = 0; i <= n; i++){
            fibonnaciArray[i] = firstNumber;
            nextNumber = firstNumber + secondNumber;
            firstNumber = secondNumber;
            secondNumber = nextNumber;

        }
//        System.out.println(Arrays.toString(fibonnaciArray));
        return fibonnaciArray[n];
    }

    // TODO:
    // create a fibonacciArray
    // on getFibonacci simply retrieve the nth number from the array

}
