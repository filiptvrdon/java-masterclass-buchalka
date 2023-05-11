package sk.filiptvrdon;

import java.util.ArrayList;
import java.util.List;

public class Predicate {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of(
                "alpha",
                "bravo",
                "charlie",
                "delta"
        ));

        for (String s : list) {
            System.out.println(s);
        }

        list.forEach((var string) -> System.out.println(string));
        System.out.println("------------------------------");

        String prefix = "nato";

        list.forEach(s -> {
            System.out.println(s);
            System.out.println(prefix + " " + s.toUpperCase());
        });


        // PREDICATE //
        list.removeIf(s -> s.equalsIgnoreCase("bravo")); // removes any element that matches the predicate //
        System.out.println(list);

        list.addAll(List.of("echo","easy","earnest"));
        list.forEach(s -> System.out.println(s));


        System.out.println("------------------------------");
        list.removeIf(s -> s.startsWith("e"));
        list.forEach(s -> System.out.println(s));




    }
}
