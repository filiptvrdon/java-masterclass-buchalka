package org.example;

import java.util.Arrays;

public class PersonImmutable {
    private final String name;
    private final String dateOfBirth;
    private final PersonImmutable[] kids;

    public PersonImmutable(String name, String dateOfBirth, PersonImmutable[] kids) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    public PersonImmutable(String name, String dateOfBirth) {
        this(name, dateOfBirth, null);
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public PersonImmutable[] getKids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
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
