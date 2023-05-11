package sk.filiptvrdon;

import java.util.Arrays;
import java.util.function.Consumer;

public class Challenge1 {
    public static void main(String[] args) {
        Consumer<String> printPartsLambda = s -> Arrays.asList(s.split(" ")).forEach(part -> System.out.println(part));
        printPartsLambda.accept("A Wild Boar was sharpening his tusks busily against the stump of a tree, when a Fox happened by.");


    }


}

