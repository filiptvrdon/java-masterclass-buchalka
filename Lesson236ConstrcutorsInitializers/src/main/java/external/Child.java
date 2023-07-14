package external;

import org.example.Parent;

import java.util.Random;

public class Child extends Parent {
    private final int birthOrder = getBirthOrder();
    private final String birthOrderString;

    {
        if (siblings == 0){
            birthOrderString = "only child";
        } else if (birthOrder == 1){
            birthOrderString = "oldest child";
        } else if (birthOrder == siblings){
            birthOrderString = "youngest child";
        } else {
            birthOrderString = "middle child";
        }
        System.out.println("Child instance initializer");
        System.out.println("birthOrderString = " + birthOrderString);
        System.out.println("birthOrder = " + birthOrder);
    }
    public Child(){
        super("Jane Doe", "01/01/1920", 5);
        System.out.println("Child constructor");
    }

    private final int getBirthOrder(){
        if (siblings == 0){
            return 1;
        } else {
            return new Random().nextInt(1, siblings + 1);
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", birthOrderString = " + birthOrderString;
    }
}
