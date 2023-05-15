import java.util.*;

public class Main {
    public static void main(String[] args) {
        Collection<String> list = new HashSet<>(Arrays.asList("Anna", "Bob", "Carol","David", "Edna"));
        System.out.println(list);

        list.add("Fred");
        list.addAll(Arrays.asList("George","Gary","Grace"));
        System.out.println(list);
        System.out.println("Is Gary in the list? " + list.contains("Gary"));

        list.removeIf(s -> s.charAt(0) == 'G');
        System.out.println(list);
        System.out.println("Is Gary in the list? " + list.contains("Gary"));

//        list.sort();
    }
}