package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainUnmodifiableCollections {
    public static void main(String[] args) {


        StringBuilder bobsNotes = new StringBuilder();
        StringBuilder billsNotes = new StringBuilder("Bill struggles with generics");

        Student bob = new Student("Bob", bobsNotes);
        Student bill = new Student("Bill", billsNotes);

        List<Student> students = new ArrayList<>(List.of(bob, bill));
        bobsNotes.append("Bob was one of my first students");

        students.forEach(System.out::println);
        System.out.println("---------------------------------------");


        List<Student> studentsFirstCopy = new ArrayList<>(students);
        studentsFirstCopy.add(new Student("John", new StringBuilder("John is a new student")));
        studentsFirstCopy.get(0).getStudentNotes().append(". Bob is a great student");
        studentsFirstCopy.forEach(System.out::println);
        System.out.println("---------------------------------------");


        //
        List<Student> studentsSecondCopy = List.copyOf(students);
        // studentsSecondCopy.set(0, (new Student("John", new StringBuilder("John is a new student"))));
        studentsSecondCopy.forEach(System.out::println);
        System.out.println("---------------------------------------");


        List<Student> studentThirdCopy = Collections.unmodifiableList(students);
        students.add(new Student("Frank", new StringBuilder("Framl is another new student")));


        studentThirdCopy.forEach(System.out::println);
//        studentThirdCopy.set(0, (new Student("John", new StringBuilder("John is a new student"))));


        System.out.println("---------------------------------------");
    }
}
