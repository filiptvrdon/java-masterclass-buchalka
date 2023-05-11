package sk.filiptvrdon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Function {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha",
                "bravo",
                "charlie",
                "delta"
        ));

        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));

        String[] emptyStrings = new String[10];
        Arrays.fill(emptyStrings,"");
        System.out.println(Arrays.toString(emptyStrings));

        Arrays.setAll(emptyStrings, (i) -> "" + (i+1) + ". ");
        Arrays.fill(emptyStrings,"");


    }
}
