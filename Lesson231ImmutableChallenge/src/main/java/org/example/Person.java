package org.example;

import java.util.Arrays;

public record Person(String name, String dob, Person[] kids){
    public Person(Person p) {
        this(p.name(), p.dob(),
                p.kids == null ? null : Arrays.copyOf(p.kids, p.kids.length));
    }
}
