package com.filiptvrdon;
import sk.filiptvrdon.Series;

public class Main {
    public static void main(String[] args) {
        int i;
        for(i = 0; i <= 10; ++i) {
            System.out.println(Series.getSum(i));
        }

        for(i = 0; i <= 10; ++i) {
            System.out.println(Series.getFactorial(i));
        }

        for(i = 0; i <= 10; ++i) {
            System.out.println(Series.getFibonacci(i));
        }
    }
}