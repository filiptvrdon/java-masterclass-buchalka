package sk.filiptvrdon;

import java.util.Arrays;
import java.util.Random;

public class Supplier {
    public static void main(String[] args) {
        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(
                15,
                names,
                () -> new Random().nextInt(0, names.length)
        );
        System.out.println(Arrays.toString(randomList));

    }


    public static String[] randomlySelectedValues(
            int count,
            String[] values,
            java.util.function.Supplier<Integer> s
    ) {
        String[] selectedValues = new String[count];
        for (int i = 0; i < count; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
