package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        List<String> someBingoNUmbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "071");

//        List<String> gNumbers = new ArrayList<>();
//
//        someBingoNUmbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
////                System.out.println(number);
//                gNumbers.add(number);
//            }
//        });
//
//        gNumbers.sort((String s1, String s2) -> s1.compareTo(s2));
//        gNumbers.forEach(System.out::println);

        someBingoNUmbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println);

        // Lesson 644 //
        Stream<String> ioNUmberStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> inNUmberStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(ioNUmberStream, inNUmberStream);

        System.out.println("------------------");
        System.out.println(concatStream
                .distinct()
                // .peek(System.out::println)
                .count());


        // Lesson 645 //

        Employee john = new Employee("John Doe", 30);
        Employee jack = new Employee("Jack Hill", 25);
        Employee jane = new Employee("Jane Deer", 27);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);

        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        System.out.println("------------------");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        System.out.println("------------------");
        List<String> sortedGNumbers = someBingoNUmbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .collect(Collectors.toList());
        sortedGNumbers.forEach(System.out::println);

        System.out.println("------------------");
        List<String> sortedGNumbersB = someBingoNUmbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
        sortedGNumbers.forEach(System.out::println);


        System.out.println("------------------");
        departments.stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);


        System.out.println("------------------");
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}