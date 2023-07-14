package org.example;

import external.Child;

public class Main {
    public static void main(String[] args) {

        Parent parent = new Parent("John Doe", "01/01/1900", 4 );
        Child child = new Child();

        System.out.println("Parent: " + parent);
        System.out.println("Child: " + child);




    }
}