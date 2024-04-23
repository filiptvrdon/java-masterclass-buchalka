package org.example;

import org.example.data.Employee;

import java.time.*;
import java.util.ArrayList;
import java.util.List;

public class MettingWindowFinder {



    public List<LocalTime> getAvailableHours(Employee employee) {
        List<LocalTime> availableHours = new ArrayList<>();
        LocalTime oclock = employee.getAvailableFrom();

        while (oclock.isBefore(employee.getAvailableTo())){
            availableHours.add(oclock);
            oclock = oclock.plusHours(1);
        }
        return availableHours;
    }

    public List<ZonedDateTime> getAvailableHoursOnDateUTC(Employee employee, LocalDate localDate) {
        List<LocalTime> availableHoursLocal = this.getAvailableHours(employee);

        return availableHoursLocal.stream()
                .map(localTime -> {
                    ZonedDateTime localDateTimeWithZone = LocalDateTime.of(localDate,localTime).atZone(employee.getZoneId());
                    return localDateTimeWithZone.withZoneSameInstant(ZoneId.of("UTC"));
                })
                .toList();

    }
}
