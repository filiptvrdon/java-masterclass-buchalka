import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Integer boxedInt = Integer.valueOf(15);
        Integer deprecatedBoxing = new Integer(15);
        int unboxedInt = boxedInt.intValue();

//        System.out.println(getDoubleObject(100.00));
//        System.out.println(getDoubleObject(100.00).getClass().getName());


        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50;
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        Character[] charArray = {'a','b','c','d'};
        System.out.println(Arrays.toString(charArray));
        System.out.println(charArray[0].getClass().getName());
    }

    private static Double getDoubleObject(double primitiveDouble){
        return Double.valueOf(primitiveDouble);
    }
}