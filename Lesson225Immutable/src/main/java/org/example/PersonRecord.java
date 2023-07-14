package org.example;

import java.util.Arrays;

public record PersonRecord(String name, String dateOfBirth, PersonRecord[] kids) {

    public PersonRecord(String name, String dateOfBirth) {
        this(name, dateOfBirth, new PersonRecord[20]);
    }

    public PersonRecord(String name, String dateOfBirth, PersonRecord[] kids) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.kids = Arrays.copyOf(kids, kids.length); // COPY OF THE ARRAY, NOT THE ACTUAL ARRAY - in order to prevent the array from being modified by client code
    }

    // RETURNING A COPY OF THE ARRAY, NOT THE ACTUAL ARRAY - in order to prevent the array from being modified by client code
    @Override
    public PersonRecord[] kids() {
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    @Override
    public String toString() {
        String kidsString = "n/a";

        if (kids != null){
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name());
            kidsString = String.join(", ", names);
        }
        return name + " " + dateOfBirth + " " + kidsString;
    }
}
