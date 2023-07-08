package org.example;

import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class IntermediateOperations {
    public static void main(String[] args) {


        Stream.iterate((int) 'A', i -> i <= 'z', i -> i + 1)
                .filter(Character::isAlphabetic)
                .map(i -> (char) i.intValue())
                .map(Character::toUpperCase)
                .distinct()
//                .filter(Character::isUpperCase)
//                .dropWhile(i -> i < 'C')
                .forEach(d -> System.out.printf("%c ", d));


        System.out.println("\n-------------------------------");

        int maxSeats = 100;
        int seatsPerRow = 10;

        var stream =
                Stream.iterate(0, i -> i <= maxSeats, i -> i + 1)
                        .map(i -> new Seat((char) ('A' + i / seatsPerRow), i % seatsPerRow + 1))
                        .sorted(Comparator.comparing(Seat::price).thenComparing(Seat::row))
                        .peek(System.out::println);

//                        .mapToDouble(Seat::price)
//                        .boxed()
//                        .map("%.2f"::formatted)

        stream.forEach(System.out::println);


    }
}
