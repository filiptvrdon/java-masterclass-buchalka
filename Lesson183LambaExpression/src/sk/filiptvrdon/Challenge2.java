package sk.filiptvrdon;

import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class Challenge2 {
    public static void main(String[] args) {

        // UnaryOperator<String> everySecondChar = source -> {
//        Function<String, String> everySecondChar = source -> {
//            StringBuilder returnVal = new StringBuilder();
//            for (int i = 0; i < source.length(); i++){
//                if (i % 2 == 1){
//                    returnVal.append(source.charAt(i));
//                }
//            }
//            return returnVal.toString();
//        };
//
//        System.out.println(everySecondChar.apply("1234567890"));


        System.out.println(
                everySecondCharacter("1234567890", source -> {
                    StringBuilder returnVal = new StringBuilder();
                    for (int i = 0; i < source.length(); i++) {
                        if (i % 2 == 1) {
                            returnVal.append(source.charAt(i));
                        }
                    }
                    return returnVal.toString();
                })
        );


    }

    public static String everySecondCharacter(String source, Function<String, String> function) {
        return function.apply(source);
    }


}
