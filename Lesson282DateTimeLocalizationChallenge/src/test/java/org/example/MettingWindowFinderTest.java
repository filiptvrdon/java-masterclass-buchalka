package org.example;

import org.example.data.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

class MettingWindowFinderTest {

    MettingWindowFinder mettingWindowFinder = new MettingWindowFinder();
    Employee employeeSydney = new Employee("Employee in Sydney", ZoneId.of("Australia/Sydney"));
    Employee employeeNewYork = new Employee("Employee in New York", ZoneId.of("America/New_York"));

    List<LocalTime> expectedHours = new ArrayList<>();

    @BeforeEach
    public void setup() {
        expectedHours.add(LocalTime.of(8, 0));
        expectedHours.add(LocalTime.of(9, 0));
        expectedHours.add(LocalTime.of(10, 0));
        expectedHours.add(LocalTime.of(11, 0));
        expectedHours.add(LocalTime.of(12, 0));
        expectedHours.add(LocalTime.of(13, 0));
        expectedHours.add(LocalTime.of(14, 0));
        expectedHours.add(LocalTime.of(15, 0));
        expectedHours.add(LocalTime.of(16, 0));
        expectedHours.add(LocalTime.of(17, 0));
        expectedHours.add(LocalTime.of(18, 0));
        expectedHours.add(LocalTime.of(19, 0));
    }


    @Test
    void getAvailableHoursTest() {
        List<LocalTime> availableHours = mettingWindowFinder.getAvailableHours(employeeSydney);
        availableHours.forEach(System.out::println);
        Assertions.assertNotNull(availableHours);
        Assertions.assertEquals(expectedHours, availableHours);
    }

    @Test
    void getAvailableHoursUTC() {
        List<ZonedDateTime> availableHoursOnDateUTC = mettingWindowFinder.getAvailableHoursOnDateUTC(employeeSydney, LocalDate.now());
        availableHoursOnDateUTC.forEach(System.out::println);
    }


}