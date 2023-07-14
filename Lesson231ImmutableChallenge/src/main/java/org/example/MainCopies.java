package org.example;


import java.util.Arrays;

public class MainCopies {
    public static void main(String[] args) {
        Person joe = new Person("Joe", "01/01/1961", null);
        Person jim = new Person("Jim", "01/01/1962", null);
        Person jack = new Person("Jack", "01/01/1963", new Person[]{joe, jim});
        Person jane = new Person("Jane", "01/01/1964", null);
        Person jill = new Person("Jill", "01/01/1965", new Person[]{joe, jim});

        Person[] persons = {joe, jim, jack, jane, jill};
        // Person[] personsCopy = Arrays.copyOf(persons, persons.length);

        // manual deep copy v1 //
        Person[] personsCopy = new Person[persons.length];
        for (int i = 0; i < persons.length; i++) {
            Person current = persons[i];
            var kids = current.kids() == null ? null : Arrays.copyOf(current.kids(), current.kids().length);
            personsCopy[i] = new Person(current.name(), current.dob(), kids);
        }

        // manual deep copy v2 //
        Person[] personsCopy2 = new Person[persons.length];
        for (int i = 0; i < persons.length; i++) {
            personsCopy2[i] = new Person(persons[i]);
        }

        // manual deep copy v3 //
        Person[] personsCopy3 = new Person[persons.length];
        Arrays.setAll(personsCopy3, i -> new Person(persons[i]));

        // manual deep copy v4 //
        Person[] personsCopy4 = persons.clone();




        var jillsKids = personsCopy4[4].kids();
        jillsKids[1] = jane;

        for (int i = 0; i < persons.length; i++) {
            if (persons[i] == personsCopy4[i]) {
                System.out.println("Same objects at index " + i);
            } else {
                System.out.println("Different objects at index " + i);
            }


        }


    }
}
