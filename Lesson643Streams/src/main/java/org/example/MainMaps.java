package org.example;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.*;

import java.util.stream.Stream;


public class MainMaps {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(5000)
                .toList();

        var mappedStudents = students.stream()
                .collect(groupingBy(Student::getCountryCode));
        mappedStudents.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("--------------------------------------------------");

        int minAge = 25;
        var youngerSet = students.stream()
                .collect(groupingBy(Student::getCountryCode, filtering(s -> s.getAge() <= minAge, toList())));
        youngerSet.forEach((k, v) -> System.out.println(k + " " + v.size()));

        System.out.println("--------------------------------------------------");

        var experienced = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience));
        System.out.println("Experienced = " + experienced.get(true).size());

        var experiencedCount = students.stream()
                .collect(partitioningBy(Student::hasProgrammingExperience, counting()));
        System.out.println("Experienced = " + experiencedCount.get(true));

        var experiencedAndActive = students.stream()
                .collect(
                        partitioningBy(
                                s -> s.hasProgrammingExperience() && s.getMonthsSinceActive() == 0,
                                counting()));
        System.out.println("Experienced and active = " + experiencedAndActive.get(true));


        var multilevelMap = students.stream()
                .collect(groupingBy(Student::getCountryCode,
                                groupingBy(Student::getGender)));
        multilevelMap.forEach((k, v) -> {
            System.out.println(k);
            v.forEach((k1, v1) -> System.out.println("  " + k1 + " " + v1.size()));
        });

    }
}
