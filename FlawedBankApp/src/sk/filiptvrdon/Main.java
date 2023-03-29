package sk.filiptvrdon;

public class Main {

    public static int multiplier = 7;
    public static void main(String[] args) {

    StaticTest staticTest1 = new StaticTest("test one");
//        System.out.println(staticTest1.getName() + " is istance number " + StaticTest.getNumInstances() );
//
//
//        StaticTest staticTest2 = new StaticTest("test two");
//        System.out.println(staticTest2.getName() + " is istance number " + StaticTest.getNumInstances() );
//
//        StaticTest staticTest3 = new StaticTest("test three");
//        System.out.println(staticTest3.getName() + " is istance number " + StaticTest.getNumInstances() );

        int answer = multiply(6);
        System.out.println(answer);

    }

    public static int multiply (int number){
        return number * multiplier;
    }

}