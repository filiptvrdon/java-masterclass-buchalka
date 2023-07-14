package org.example;

public class Parent {

    static {
        System.out.println("Parent static initializer, Parent class is being constructed");
    }

    private final String name;
    private final String dob;

    protected final int siblings;

    // instance initializer
    {
//        name = "John Doe";
//        dob = "01/01/1900";
        System.out.println("Parent instance initializer");
    }

//    public Parent() {
//        System.out.println("Parent no args constructor");
//    }

    public Parent(String name, String dob, int siblings){
        this.name = name;
        this.dob = dob;
        this.siblings = siblings;
        System.out.println("Parent constructor");
    }

    public String getName() {
        return name;
    }

    public String getDob() {
        return dob;
    }

    @Override
    public String toString() {
        return "name = " + name + ", dob = " + dob + "";
    }
}
