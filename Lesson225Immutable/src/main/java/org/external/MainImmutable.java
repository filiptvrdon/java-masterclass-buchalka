package org.external;

import org.example.PersonImmutable;

public class MainImmutable {

    public static void main(String[] args) {
        PersonImmutable jane = new PersonImmutable("Jane", "01/01/2020");
        PersonImmutable jim = new PersonImmutable("Jim", "01/01/2022");
        PersonImmutable joe = new PersonImmutable("Joe", "01/01/2024");

        PersonImmutable[] johnsKids = {jane, jim, joe};

        PersonImmutable john = new PersonImmutable("John", "01/01/1990", johnsKids);
        System.out.println("Printing John");
        System.out.println(john);

        PersonImmutable[] kids = john.getKids();
        kids[0] = jane;
        kids[1] = new PersonImmutable("Walter", "01/01/2023");

        System.out.println("Printing John After altering kids");
        System.out.println(john);

        johnsKids[0] = new PersonImmutable("Susan", "01/01/2021");
        System.out.println("Printing John");
        System.out.println(john);
    }
}
