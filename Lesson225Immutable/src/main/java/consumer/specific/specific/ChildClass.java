package consumer.specific.specific;

import org.example.BaseClass;

public class ChildClass extends BaseClass {

    @Override
    protected void optionalMethod() {
        System.out.println("EXTRA STUFF - OPTIONAL");
        super.optionalMethod();
    }

//    @Override
//    public void recommendedMethod() {
//        System.out.println("EXTRA STUFF - RECOMMENDED");
//        optionalMethod();
//    }

    public static void recommendedStatic(){
        System.out.println("CHILD:  recommended static method");
        optionalStatic();
        // mandatoryStatic();
    }


}
