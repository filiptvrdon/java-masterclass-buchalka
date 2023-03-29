package sk.filiptvrdon;

public class Main {
    public static void main(String[] args) {

//        SomeClass one = new SomeClass("one");
//        SomeClass two = new SomeClass("two");
//        SomeClass three = new SomeClass("three");
//
//        System.out.println(one.getInstanceNumber());
//        System.out.println(two.getInstanceNumber());
//        System.out.println(three.getInstanceNumber());
//
//        System.out.println(Math.PI);
//
//
//        int pw = 7654345;
//        Password password = new ExtendedPassword(pw);
//        password.storePassword();
//
//        password.login(876);
//        password.login(-1);
//        password.login(88765456);
//        password.login(pw);

        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is "+ test.owner);

    }
}