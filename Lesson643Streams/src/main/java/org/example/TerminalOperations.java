package org.example;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TerminalOperations {
    public static void main(String[] args) {

        var result = IntStream.iterate(0, i -> i <= 1000, i -> i + 1)
                .summaryStatistics();
        System.out.println("result = " + result);

        var leapYearData = IntStream
                .iterate(2000, i -> i <= 2025, i -> i + 1)
                .filter(i -> i % 4 == 0)
                .peek(System.out::println)
                .summaryStatistics();
        System.out.println("leapYearData = " + leapYearData);

        SeatReserved[] seats = new SeatReserved[100];
        Arrays.setAll(seats, i -> new SeatReserved((char) ('A' + i / 10), i % 10 + 1));
//        Arrays.asList(seats).forEach(System.out::println);

        var seatsStream = Arrays
                .stream(seats)
                .filter(SeatReserved::reserved)
                .count();
        System.out.println("seatsStream = " + seatsStream);

        var hasBookings = Arrays
                .stream(seats)
                .anyMatch(SeatReserved::reserved);
        System.out.println("hasBookings = " + hasBookings);

        var isBookedOut = Arrays
                .stream(seats)
                .allMatch(SeatReserved::reserved);
        System.out.println("isBookedOut = " + isBookedOut);

        var isWashedOut = Arrays
                .stream(seats)
                .noneMatch(SeatReserved::reserved);
        System.out.println("isWashedOut = " + isWashedOut);



    }

}
