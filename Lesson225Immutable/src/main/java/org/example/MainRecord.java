package org.example;

public class MainRecord {
    public static void main(String[] args) {
        PersonRecord jane = new PersonRecord("Jane", "01/01/2020");
        PersonRecord jim = new PersonRecord("Jim", "01/01/2022");
        PersonRecord joe = new PersonRecord("Joe", "01/01/2024");

        PersonRecord[] johnsKids = {jane, jim, joe};

        PersonRecord john = new PersonRecord("John", "01/01/1990", johnsKids);
        System.out.println("Printing John");
        System.out.println(john);

        PersonRecord johnCopy = new PersonRecord("John", "01/01/1990");
        System.out.println("Printing John Copy");
        System.out.println(johnCopy);

        PersonRecord[] kids = johnCopy.kids();
        kids[0] = jane;
        kids[1] = new PersonRecord("Walter", "01/01/2023");

        System.out.println("Printing John Copy After altering kids");
        System.out.println(johnCopy);

        johnsKids[0] = new PersonRecord("Susan", "01/01/2021");
        System.out.println("Printing John");
        System.out.println(john);
    }
}
