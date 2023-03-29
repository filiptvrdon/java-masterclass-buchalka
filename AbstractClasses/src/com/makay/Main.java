package com.makay;

public class Main {
    public static void main(String[] args) {

        Dog york = new Dog("Yorkie");
        york.breathe();
        york.eat();

        Bird hedwig = new Owl("Hedvig");
        hedwig.breathe();
        hedwig.eat();
        hedwig.fly();
    }


}