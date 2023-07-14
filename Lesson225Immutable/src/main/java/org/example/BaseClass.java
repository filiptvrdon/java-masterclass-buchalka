package org.example;

public class BaseClass {

    public final void recommendedMethod(){
        System.out.println("This is the recommended method");
        optionalMethod();
        mandatoryMethod();
    }

    protected void optionalMethod(){
        System.out.println("This is the optional method");
    }

    private void mandatoryMethod(){
        System.out.println("This is the mandatory method - non negotiable!");
    }

    public static void recommendedStatic(){
        System.out.println("This is the recommended static method");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic(){
        System.out.println("This is the optional static method");
    }

    private static void mandatoryStatic(){
        System.out.println("This is the mandatory static method - non negotiable!");
    }



}
