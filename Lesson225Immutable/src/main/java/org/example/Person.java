package org.example;

import java.util.Arrays;

public class Person {

    private String name;
    private String dateOfBirth;
    private Person[] kids;


    public Person(String name, String dateOfBirth, Person[] kids) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.kids = kids;
    }

    public Person(String name, String dateOfBirth) {
        this(name, dateOfBirth, null);
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public Person[] getKids() {
        return kids;
    }

    public void setKids(Person[] kids) {
        this.kids = kids;
    }

    @Override
    public String toString() {
        String kidsString = "n/a";

        if (kids != null){
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].getName());
            kidsString = String.join(", ", names);
        }
        return name + " " + dateOfBirth + " " + kidsString;


    }
}
