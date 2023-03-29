package org.example;

public class Main {
    public static void main (String[] args){
        for (int i = 0; i<= 10; i++){
            System.out.println(Series.getSum(i));
        }

        for (int i = 0; i<= 10; i++){
            System.out.println(Series.getFactorial(i));
        }

        for (int i = 0; i<= 10; i++){
            System.out.println(Series.getFibonacci(i));
        }

    }
}
