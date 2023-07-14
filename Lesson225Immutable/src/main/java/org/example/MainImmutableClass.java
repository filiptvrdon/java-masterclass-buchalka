package org.example;

public class MainImmutableClass {
    public static void main(String[] args) {
//        Person jane = new Person();
//        jane.setName("Jane");
//
//        Person jim  = new Person();
//        jim.setName("Jim");
//
//        Person john = new Person();
//        john.setName("John");
//        john.setDateOfBirth("01/01/2000");
//        john.setKids(new Person[]{jane, jim});
//        System.out.println(john);

        Person jane = new Person("Jane", "01/01/2020");
        Person jim = new Person("Jim", "01/01/2022");
        Person joe = new Person("Joe", "01/01/2024");

        Person[] johnsKids = {jane, jim, joe};

        Person john = new Person("John", "01/01/1990", johnsKids);
        System.out.println(john);

        john.setKids(null);
        System.out.println(john);


    }
}
