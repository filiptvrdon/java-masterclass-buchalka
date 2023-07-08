package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class MainTerminalOpChallenge {
    private static final double AVERAGE_MULTIPLIER = 1.5;

    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);
        Course cgj = new Course("CGJ", "Creating Games with Java");

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc, cgj))
                .limit(5000)
                .toList();

        var average = students.stream()
                .mapToDouble(s -> s.getPercentComplete(jmc.courseCode()))
                .average();

        List<Student> studentsWithProgress = students.stream()
                .filter(s -> s.getPercentComplete(jmc.courseCode()) > average.getAsDouble() * AVERAGE_MULTIPLIER)
                .toList();

        System.out.println("Average = " + average.getAsDouble());
        System.out.println("Number of Students with progress :" + studentsWithProgress.size());
        studentsWithProgress.forEach(s -> System.out.print(s.getStudentId() + " "));

        List<Student> topTenStudents =  studentsWithProgress.stream()
                .filter(s -> s.getMonthsSinceActive() == 0)
                .sorted(Comparator.comparingInt(Student::getYearsSinceEnrolled))
                .limit(10)
                .toList();

        topTenStudents.forEach(s -> s.addCourse(cgj));






    }
}
