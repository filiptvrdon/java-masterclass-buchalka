package sk.filiptvrdon;

public class SIBTest {

    public static final String owner;

    static{
        owner = "tim";
        System.out.println("SIB TEST static initialization block called");
    }

    public SIBTest(){
        System.out.println("SIB Constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }


    public void someMethod(){
        System.out.println("Some method called");
    }
}
