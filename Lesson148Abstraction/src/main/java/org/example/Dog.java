package org.example;

public class Dog extends Animal{
    public Dog(String type, String size, String weight) {
        super(type, size, weight);
    }

    @Override
    public void move() {
        System.out.println(getExplicitType() + " is moving");
    }

    @Override
    public void makeNoise() {
        if (type.equals("Wolf")) {
            System.out.println(getExplicitType() + " is howling");
        } else {
            System.out.println(getExplicitType() + " is woofing");
        }
    }
}
