import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class Challenges {

    public static void main(String[] args) {
        String[] names = {"Tim", "bob", "mARTIN", "anNa"};
        System.out.println(Arrays.toString(names));

        UnaryOperator<String> toUpperCase = String::toUpperCase;

        UnaryOperator<String> addMiddleName = s -> {
            Random r = new Random();
            return s + (" " + (char) (r.nextInt(26) + 'a') + ".").toUpperCase();
        };

        UnaryOperator<String> addLastName = s -> s + s.split(" ")[0].transform(str -> {
            String[] split = str.split("");
            StringBuilder reverse = new StringBuilder();
            for (int i = split.length; i > 0; i--) {
                reverse.append(split[i - 1]);
            }
            return reverse;
        });

//        List<UnaryOperator<String>> functions = new ArrayList<>();
//        functions.add(toUpperCase);
//        functions.add(addMiddleName);
//        functions.add(addLastName);

//        applyChanges(names, functions);


        Function<String, String> f = toUpperCase
                .andThen(addMiddleName)
                .andThen(addLastName);

        System.out.println("RESULTS OF CONVENIENCE METHODS");
        for (String name : names) {
            System.out.println(f.apply(name));
        }

        System.out.println("CONSUMER CHAINING");
        Consumer<String> s0 = s -> System.out.print(s.charAt(0));
        Consumer<String> s1 = System.out::println;
        Arrays.asList(names).forEach(s0
                .andThen(s -> System.out.print(" - "))
                .andThen(s1));

        System.out.println("PREDICATE CHAINING");
        Predicate<String> p1 = s -> s.equals("TIM");
        Predicate<String> p2 = s -> s.equalsIgnoreCase("tim");
        Predicate<String> p3 = s -> s.startsWith("T");
        Predicate<String> p4 = s -> s.endsWith("e");

        Predicate<String> combined1 = p1.or(p2);
        System.out.println("COMBINED 1: " + combined1.test("Tim"));

//        Predicate<String> combined2 = p3.and(p4);
        Predicate<String> combined2 = p3.and(p4).negate();
        System.out.println("COMBINED 2: " + combined2.test("Tim"));


        record Person(String firstName, String lastName) {
        }

        List<Person> list = new ArrayList<>(Arrays.asList(
                new Person("Peter", "Pan"),
                new Person("Peter", "PumpkinEater"),
                new Person("Minnie", "Mouse"),
                new Person("Mickey", "Mouse")
        ));
        System.out.println("___________________________________");
        list.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        list.forEach(System.out::println);

        System.out.println("___________________________________");
        list.sort(Comparator.comparing(Person::lastName));
        list.forEach(System.out::println);

        System.out.println("___________________________________");
        list.sort(Comparator.
                comparing(Person::lastName).
                thenComparing(Person::firstName));
        list.forEach(System.out::println);

        System.out.println("___________________________________");
        list.sort(Comparator.
                comparing(Person::lastName).
                thenComparing(Person::firstName).reversed());
        list.forEach(System.out::println);


    }

    public static void applyChanges(String[] names, List<UnaryOperator<String>> functions) {
        List<String> namesList = Arrays.asList(names);
        for (var function : functions) {
            namesList.replaceAll(s -> s.transform(function));
            System.out.println(Arrays.toString(names));
        }

    }


}
