package org.example;

import org.example.data.Employee;

import java.time.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        MettingWindowFinder mettingWindowFinder = new MettingWindowFinder();
        Employee employeeSydney = new Employee("Employee in Sydney", ZoneId.of("Australia/Sydney"));
        Employee employeeNewYork = new Employee("Employee in New York", ZoneId.of("America/New_York"));

        List<LocalTime> availableHours = mettingWindowFinder.getAvailableHours(employeeSydney);
        availableHours.forEach(System.out::println);
        System.out.println("==================================================");

        List<ZonedDateTime> availableHoursSydneyUTC = mettingWindowFinder.getAvailableHoursOnDateUTC(employeeSydney, LocalDate.now().plusDays(1));
        availableHoursSydneyUTC.forEach(System.out::println);
        System.out.println("==================================================");

        List<ZonedDateTime> availableHoursNewYorkUTC = mettingWindowFinder.getAvailableHoursOnDateUTC(employeeNewYork, LocalDate.now().plusDays(1));
        availableHoursNewYorkUTC.forEach(System.out::println);
        System.out.println("==================================================");

//        System.out.println(availableHoursSydneyUTC.stream()
//                        .map(zonedDateTime -> LocalDate)
//                .filter(localDate -> )
//                .toList());

        Map<ZonedDateTime,ZonedDateTime> overlappingOClock = new TreeMap<>();
        for (ZonedDateTime sydneyOClock : availableHoursSydneyUTC){
            for (ZonedDateTime newYorkOClock : availableHoursNewYorkUTC){
                if (sydneyOClock.equals(newYorkOClock)|| sydneyOClock.equals(newYorkOClock.plusDays(1)) || sydneyOClock.equals(newYorkOClock.minusDays(1))){
                    overlappingOClock.put(sydneyOClock,newYorkOClock);
                    System.out.println("UTC time:" + sydneyOClock);
                    System.out.println("Sydney time: " + sydneyOClock.withZoneSameInstant(employeeSydney.getZoneId()));
                    System.out.println("New York time: " + newYorkOClock.withZoneSameInstant(employeeNewYork.getZoneId()));
                    System.out.println("------");
                }
            }
        }









    }

}


