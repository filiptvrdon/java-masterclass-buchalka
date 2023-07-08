package org.example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainStreamsChallenge {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 706);
        Course cgj = new Course("CGJ", "Creating Games with Java", 254);


        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc, cgj))
                .filter(s -> s.getYearsSinceEnrolled() <= 4)
                .limit(10000)
                .toList();
        System.out.println(students.size());

        System.out.println(students
                .stream()
                .mapToInt(Student::getYearEnrolled)
                .summaryStatistics());

        students.subList(0,10).forEach(System.out::println);

        System.out.println(students
                .stream()
                .mapToInt(s -> s.getEngagementMap().size())
                .summaryStatistics());

        var mappedActivity = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode, Collectors.counting()));

        mappedActivity.forEach((k,v) -> System.out.println(k + " : " + v));

        System.out.println("-----------------".repeat(3));

        var classCounts = students.stream()
                        .collect(Collectors.groupingBy(s -> s.getEngagementMap().size(), Collectors.counting()));

        classCounts.forEach((k,v) -> System.out.println(k + " : " + v));

        System.out.println("-----------------".repeat(3));

        var percentages = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode, Collectors.summarizingDouble(CourseEngagement::getPercentComplete)));
        percentages.forEach((k,v) -> System.out.println(k + " : " + v));


        var yearMap = students.stream()
                .flatMap(s -> s.getEngagementMap().values().stream())
                .collect(Collectors.groupingBy(CourseEngagement::getCourseCode,
                        Collectors.groupingBy(CourseEngagement::getLastActivityYear, Collectors.counting())));
        yearMap.forEach((k,v) -> System.out.println(k + " : " + v));


    }
}
