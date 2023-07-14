package org.example;

import consumer.specific.specific.ChildClass;

import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {


        /*
        Final method - cannot be overridden by a subclass
        Final field - cannot be changed after initialization
        Final static field - cannot be changed after initialization, this is the default on interface fields
        Final class - cannot be extended
        final variable - cannot be changed after initialization
        final method parameter - cannot be changed after initialization
        */
        BaseClass parent = new BaseClass();
        ChildClass child = new ChildClass();
        BaseClass childRefferedToAsBase = new ChildClass();

        parent.recommendedMethod();
        System.out.println("----------------------------------");
        childRefferedToAsBase.recommendedMethod();
        System.out.println("----------------------------------");
        child.recommendedMethod();

        System.out.println("========================================");
        parent.recommendedStatic();
        System.out.println("----------------------------------");
        childRefferedToAsBase.recommendedStatic();
        System.out.println("----------------------------------");
        child.recommendedStatic();


        System.out.println("========================================");
        BaseClass.recommendedStatic();
        ChildClass.recommendedStatic();


        String xArgument = "This is all I've got to say about section ";
        int yArgument = 42;
        doXYZ(xArgument, yArgument);

    }

    private static void doXYZ(String x, int y) {
        final String c = x + y;
        System.out.println("c = " + c);
//        c = "something else";
    }
}