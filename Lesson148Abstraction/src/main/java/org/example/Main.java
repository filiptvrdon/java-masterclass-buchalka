package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog("Dog", "Medium", "20kg");
//        dog.move();
//        dog.makeNoise();

        doAnimalStuff(dog);

        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(dog);
        animals.add(new Fish("Fish", "Small", "1kg"));
        animals.add(new Dog("Big dog", "Large", "50kg"));
        animals.add(new Fish("Shark", "Large", "100kg"));
        animals.add(new Dog("Wolf", "Large", "60kg"));

        animals.forEach(Main::doAnimalStuff);

    }



    private static void doAnimalStuff(Animal animal) {
        animal.move();
        animal.makeNoise();
    }
}