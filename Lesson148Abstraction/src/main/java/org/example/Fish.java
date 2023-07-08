package org.example;

public class Fish extends Animal{
    public Fish(String type, String size, String weight) {
        super(type, size, weight);
    }

    @Override
    public void move() {
        System.out.println(getExplicitType() + " is swimming");
    }

    @Override
    public void makeNoise() {
        System.out.println(getExplicitType() + " is splashing");
    }
}
