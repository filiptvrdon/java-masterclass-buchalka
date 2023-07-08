package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainTerminalOptional {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .collect(Collectors.toList());

        int minAge = 21;
        students.stream()
                .filter(s -> s.getAge() > minAge)
                .findAny()
                .ifPresentOrElse(s -> System.out.println("Student = " + s.getStudentId() + " " + s.getAge()),
                        () -> System.out.println("No Student found"));
    }
}
