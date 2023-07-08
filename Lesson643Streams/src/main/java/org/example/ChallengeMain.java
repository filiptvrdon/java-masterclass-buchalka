package org.example;

import java.time.Year;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ChallengeMain {

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");
//        Student tim = new Student("AU", 2019, 30, "M",
//                true, jmc, pymc);
//        System.out.println(tim);
//
//        tim.watchLecture("JMC", 10, 5, 2019);
//        tim.watchLecture("PYMC", 7, 7, 2020);
//        System.out.println(tim);

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(100)
                .collect(Collectors.toList());

        var maleStudents = students.stream()
                .filter(s -> s.getGender().equals("M"))
                .count();
        System.out.println("maleStudents = " + maleStudents);
        System.out.println("femaleStudents = " + (students.size() - maleStudents));


        System.out.println("studentsOver60 = " + students.stream()
                .filter(s -> s.getAge() > 60)
                .count());

        System.out.println("studentsBetween30and60 = " + students.stream()
                .filter(s -> s.getAge() >= 30 && s.getAge() <= 60)
                .count());

        System.out.println("studentsUnder30 = " + students.stream()
                .filter(s -> s.getAge() < 30)
                .count());

        System.out.print("list of countries: ");
        students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .forEach(s -> System.out.print(s + " "));

        System.out.print("\n Number of active students: " +
                         students.stream()
                                 .filter(s -> s.getMonthsSinceActive() == 0)
                                 .count());

//        List<Student> longTermStudents = students.stream()
//                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
//                             s.getMonthsSinceActive() < 12)
//                .filter(s -> !s.hasProgrammingExperience())
//                .limit(5)
//                .toList();
//        System.out.println("\nlongTermStudents = " + longTermStudents);

//        var longTermStudents = students.stream()
//                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
//                             s.getMonthsSinceActive() < 12)
//                .filter(s -> !s.hasProgrammingExperience())
//                .limit(5)
//                .toArray(Student[]::new);
//        System.out.println("\nlongTermStudents = " + longTermStudents);


        var learners = students.stream()
                .filter(s -> (s.getAge() - s.getAgeEnrolled() >= 7) &&
                             s.getMonthsSinceActive() < 12)
                .filter(s -> !s.hasProgrammingExperience())
                .limit(5)
                .collect(Collectors.toList());
        Collections.shuffle(learners);

    }


}
