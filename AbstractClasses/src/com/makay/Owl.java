package com.makay;

public class Owl extends Bird{
    public Owl(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println(getName() + " spreads wings and takes off");
    }
}
