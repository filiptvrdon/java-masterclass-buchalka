package org.example.data;

import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private ZoneId zoneId;

    private LocalTime availableFrom;
    private LocalTime availableTo;

    public String getName() {
        return name;
    }

    public ZoneId getZoneId() {
        return zoneId;
    }

    public LocalTime getAvailableFrom() {
        return availableFrom;
    }

    public LocalTime getAvailableTo() {
        return availableTo;
    }

    public Employee(String name, ZoneId zoneId) {
        this.name = name;
        this.zoneId = zoneId;
        this.availableFrom = LocalTime.of(8, 0);
        this.availableTo = LocalTime.of(21, 0);
    }




}
