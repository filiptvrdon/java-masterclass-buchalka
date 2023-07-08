package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Challenge {
    public static void main(String[] args) {

        System.out.println("B NUMBERS");
        int[] bNumbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        var bStream = Arrays.stream(bNumbers)
                .mapToObj(s -> "B" + s);

        System.out.println("I NUMBERS");
        var iStream = IntStream.rangeClosed(15, 30)
                .mapToObj(s -> "I" + s);

        System.out.println("N NUMBERS");
        var nStream = Stream.iterate(31, n -> n + 1)
                .limit(15)
                .map(s -> "N" + s);

        System.out.println("G NUMBERS");


    }
}
