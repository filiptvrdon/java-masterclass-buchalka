package org.example;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainCollect {
    public static void main(String[] args) {
        Course pymc = new Course("PYMC", "Python Masterclass");
        Course jmc = new Course("JMC", "Java Masterclass");

        List<Student> students =
                Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                        .limit(1000)
                        .toList();

        Set<Student> australianStudents = students.stream()
                .filter(s -> s.getCountryCode().equals("AU"))
                .collect(Collectors.toSet());
        System.out.println("# of Australian Students = " + australianStudents.size());

        Set<Student> under30 = students.stream()
                .filter(s -> s.getAge() < 30)
                .collect(Collectors.toSet());
        System.out.println("# of Students under 30 = " + under30.size());

//        Set<Student> aussiesUnder30 = new TreeSet<>(Comparator.comparing(Student::getStudentId));
//        aussiesUnder30.addAll(australianStudents);
//        aussiesUnder30.retainAll(under30);
//        aussiesUnder30.forEach((s) -> System.out.print(s.getStudentId() + " "));
//        System.out.println();

        Set<Student> aussiesUnder30 = students.stream()
                .filter(s -> s.getAge() < 30)
                .filter(s -> s.getCountryCode().equals("AU"))
                .collect(() -> new TreeSet<>(Comparator.comparing(Student::getStudentId)),
                        TreeSet::add,
                        TreeSet::addAll);

        aussiesUnder30.forEach((s) -> System.out.print(s.getStudentId() + " "));
        System.out.println("# of Aussie Students under 30 = " + aussiesUnder30.size());

        String countryList = students.stream()
                .map(Student::getCountryCode)
                .distinct()
                .sorted()
                .reduce("", (concatenatedString,countryCode) -> concatenatedString + " " + countryCode);
System.out.println("countryList = " + countryList);



    }
}
