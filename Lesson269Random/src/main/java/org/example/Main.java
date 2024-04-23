package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------");
        Random random = new Random();
        random.ints(0,1001)
                .limit(10)
                .forEach(System.out::println);

        System.out.println("---------------------------------");
        random.ints(10, 0,1001)
                .forEach(System.out::println);


        // suitable for testing purposes
        System.out.println("---------------------------------");
        long nanoTime = System.nanoTime();
        Random pseudoRandom = new Random(nanoTime);
        pseudoRandom.ints(10,0,10)
                .forEach( i-> System.out.print(i + ""));

        System.out.println("\n---------------------------------");
        Random notReallyRandom = new Random(nanoTime);
        notReallyRandom.ints(10,0,10)
                .forEach( i-> System.out.print(i + ""));

        //



    }
}