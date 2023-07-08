package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MainOptional {
    public static void main(String[] args) {

        Course pymc = new Course("PYMC", "Python Masterclass", 50);
        Course jmc = new Course("JMC", "Java Masterclass", 100);

        List<Student> students = Stream.generate(() -> Student.getRandomStudent(jmc, pymc))
                .limit(1000)
                .collect(Collectors.toList());

        Optional<Student> o1 = getStudent(new ArrayList<>(), "first");
        System.out.println("Empty Optional = " + o1.isEmpty());
        System.out.println("Present Optional = " + o1.isPresent());
        System.out.println("Student = " + o1);
//        o1.ifPresent(student -> System.out.println("Student = " + student));
        o1.ifPresentOrElse(student -> System.out.println("Student = " + student),
                () -> System.out.println("No Student found"));

        System.out.println("--------------------------------------------------");

        // students.add(0,null);
        Optional<Student> o2 = getStudent(students, "first");
        System.out.println("Empty Optional = " + o2.isEmpty());
        System.out.println("Present Optional = " + o2.isPresent());
        System.out.println("Student = " + o2);
        System.out.println("Student = " + o2.get());

    }

    private static Optional<Student> getStudent(List<Student> list, String type){
        if (list == null || list.size() == 0){
            return Optional.empty();
        } else if (type.equals("first")){
            return Optional.ofNullable(list.get(0));
        } else if (type.equals("last")){
            return Optional.ofNullable(list.get(list.size() - 1));
        } else {
            return Optional.ofNullable(list.get(new Random().nextInt(list.size())));
        }
    }
}
