import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.*;

class PlainOld {
    private static int last_id = 1;
    private int id;

    public PlainOld() {
        id = PlainOld.last_id++;
        System.out.println("creting a PlainOld Object: id = " + id);
    }

}

public class Main {
    public static void main(String[] args) {

                List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));
        list.forEach(System.out::println);

        calculator(Integer::sum, 10, 25);
        calculator(Double::sum, 2.5, 14.25);

        Supplier<PlainOld> reference1 = PlainOld::new;
        reference1.get();

        System.out.println("Getting Array");
        PlainOld[] pojo1 = seedArray(PlainOld::new, 10);

        calculator(String::concat, "Hello", "World");


        BinaryOperator<String> b1 = String::concat;
        BiFunction<String, String, String> b2 = String::concat;
        UnaryOperator<String> u1 = String::toUpperCase;

        System.out.println(b1.apply("Hello","World"));
        System.out.println(b2.apply("Olá","Mundo"));
        System.out.println(u1.apply("Ciao!"));


        String result = "Hello".transform(u1);
        System.out.println("Result: " + result);

        result = "Hello".transform(String::toLowerCase);
        System.out.println("Result: " + result);

        Function<String, Boolean> f0 = String::isEmpty;
        boolean resultBoolean = result.transform(f0);
        System.out.println("Result: " + resultBoolean);





    }

    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("Result of operation: " + result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count) {
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;
    }
}