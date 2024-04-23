package org.example;

import java.time.LocalDate;
import java.time.LocalTime;

public class MainLocalTime {
    public static void main(String[] args) {


        LocalTime time = LocalTime.now();
        System.out.println(time);

        System.out.println(LocalTime.of(7,0));
        System.out.println(LocalTime.of(7,30, 23));
        System.out.println(LocalTime.of(7,30, 24, 8765));




    }
}
