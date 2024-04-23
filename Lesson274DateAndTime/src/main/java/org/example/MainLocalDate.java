package org.example;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoField;

public class MainLocalDate {
    public static void main(String[] args) {

        LocalDate today = LocalDate.now();
        System.out.println(today);

        LocalDate cincoDeMayo = LocalDate.of(2022,5,5);
        System.out.println(cincoDeMayo);

        LocalDate may5th = LocalDate.of(2022, Month.MAY,5);
        System.out.println(may5th);

        LocalDate may5FromString = LocalDate.parse("2022-05-05");
        System.out.println(may5FromString);
        System.out.println("--------------------------------------------");

        System.out.println(may5th.getYear());
        System.out.println(may5th.getMonth());
        System.out.println(may5th.getMonthValue());
        System.out.println(may5th.getDayOfWeek());
        System.out.println(may5th.getDayOfMonth());
        System.out.println(may5th.getDayOfYear());
        System.out.println("--------------------------------------------");

        System.out.println(may5th.get(ChronoField.YEAR));
        System.out.println(may5th.get(ChronoField.MONTH_OF_YEAR));
        System.out.println(may5th.get(ChronoField.DAY_OF_WEEK));
        System.out.println(may5th.get(ChronoField.DAY_OF_MONTH));
        System.out.println(may5th.get(ChronoField.DAY_OF_YEAR));
        System.out.println("--------------------------------------------");


        // WITH- and PLUS- methods return new instances -> java.time classes are immutable
        System.out.println(may5th.withYear(2000));
        System.out.println(may5th.withMonth(3));
        System.out.println(may5th.withDayOfMonth(1));
        System.out.println(may5th.withDayOfYear(2));
        System.out.println(may5th.with(ChronoField.DAY_OF_YEAR, 3));
        System.out.println(may5th);
        System.out.println("--------------------------------------------");

        System.out.println(may5th.plusYears(10));
        System.out.println(may5th.plusMonths(3));
        System.out.println(may5th.plusWeeks(1));
        System.out.println(may5th.plusDays(365));
        System.out.println(may5th);
        System.out.println("--------------------------------------------");


        System.out.println("may 5 > today? " + may5th.isAfter(today));
        System.out.println("may 5 < today? " + may5th.isBefore(today));
        System.out.println("--------------------------------------------");

        System.out.println("may 5 > today? " + may5th.compareTo(today));
        System.out.println("may 5 < today? " + today.compareTo(may5th));
        System.out.println("--------------------------------------------");

        System.out.println("today = date now? " + today.compareTo(LocalDate.now()));
        System.out.println("today = date now? " + today.equals(LocalDate.now()));
        System.out.println("--------------------------------------------");

        System.out.println("is leap year " + may5th.isLeapYear());
        System.out.println("is leap year? " + may5th.minusYears(2).isLeapYear());
        System.out.println("--------------------------------------------");


        // GET A STREAM OF DATES FROM THE STARTING DATE (INCLUDING) UNTIL THE TARGET DATE (EXCLUDED)
        today.datesUntil(today.plusYears(1))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------");

        // WITH INCREMENTS OF SPECIFIED PERIOD
        today.datesUntil(today.plusYears(1), Period.ofDays(7))
                .forEach(System.out::println);
        System.out.println("--------------------------------------------");





    }
}