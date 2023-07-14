import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<Contact> phones = ContactData.getData("phone");
        List<Contact> emails = ContactData.getData("email");


        // Contact does not implement Comparable -> exception occurs //
//        NavigableSet<Contact> sorted = new TreeSet<>(phones);
//        sorted.forEach(System.out::println);

        Comparator<Contact> byName = Comparator.comparing(Contact::getName);
        NavigableSet<Contact> sorted = new TreeSet<>(byName);
        sorted.addAll(phones);
        sorted.forEach(System.out::println);


        NavigableSet<String> names = new TreeSet<>();
        phones.forEach(s -> names.add(s.getName()));
        System.out.println(names);

        NavigableSet<Contact> fullSet = new TreeSet<>(sorted);
        fullSet.addAll(emails);
        fullSet.forEach(System.out::println);


        List<Contact> fullList = new ArrayList<>(phones);
        fullList.addAll(emails);
        fullList.sort(sorted.comparator());
        System.out.println("________________________________________________________________");
        fullList.forEach(System.out::println);


        Contact min = Collections.min(fullSet, fullSet.comparator());
        Contact max = Collections.max(fullSet, fullSet.comparator());

        Contact first = fullSet.first();
        Contact last = fullSet.last();

        System.out.println("________________________________________________________________");
        System.out.println("min: " + min);
        System.out.println("max: " + max);
        System.out.println("first: " + first);
        System.out.println("last: " + last);
        System.out.println("________________________________________________________________");

        NavigableSet<Contact> copiedSet = new TreeSet<>(fullSet);
        System.out.println("First element = " + copiedSet.pollFirst());
        System.out.println("Last element = " + copiedSet.pollLast());
        copiedSet.forEach(System.out::println);
        System.out.println("________________________________________________________________");



        Contact daffy = new Contact("Daffy Duck");
        Contact bugs = new Contact("Bugs Bunny");
        Contact elmer = new Contact("Elmer Fudd");
        Contact porky = new Contact("Porky Pisg");

        for (Contact c : List.of(daffy, bugs, elmer, porky)) {
            System.out.println("Adding " + c);
            copiedSet.add(c);
        }
    }


}
