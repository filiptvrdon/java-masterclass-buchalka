package sk.filiptvrdon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.random.RandomGenerator;

class Person{
    String firstname;
    String middleName;
    String lastName;

    public Person(String firstname) {
        this.firstname = firstname;
        this.middleName = "";
        this.lastName = "";
    };

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return firstname + " " + middleName + " " + lastName;
    }
}

public class ChallengeFinal {



    public static void main(String[] args) {
        String[] names = {"Tim", "bob", "mARTIN", "anNa"};
        ArrayList<Person> people = new ArrayList<>();

        for (String name : names) {
            people.add(new Person(name));
        }

        people.forEach(person -> System.out.println(person));



        people.forEach(person -> {
            Random r = new Random();
            String name = person.getFirstname();
            person.setFirstname(name.toUpperCase());
            person.setMiddleName((" " + (char) (r.nextInt(26) + 'a') + ".").toUpperCase());
            person.setLastName(new StringBuilder(person.getFirstname()).reverse().toString());
        });

        people.forEach(person -> System.out.println(person));
        System.out.println("_______________________________________________________-");
        people.removeIf(person -> person.getFirstname().equals(person.getLastName()));

        people.forEach(person -> System.out.println(person));

//
//        System.out.println(Arrays.toString(names));
//
//        Arrays.asList(names).replaceAll(name -> name.toUpperCase());
//
//        Arrays.asList(names).replaceAll(name -> {
//            Random r = new Random();
//            return name + (" " + (char) (r.nextInt(26) + 'a') + ".").toUpperCase();
//        });
//
//        Arrays.asList(names).replaceAll(name -> {
//
//                });
//
//
//                System.out.println(Arrays.toString(names));
    }
}
