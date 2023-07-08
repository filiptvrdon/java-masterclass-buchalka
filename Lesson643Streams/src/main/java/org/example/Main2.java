package org.example;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main2 {
    public static void main(String[] args) {
        List<String> bingoPool = new ArrayList<>(75);
        int start = 1;
        for (char c : "BINGO".toCharArray()) {
            for (int i = start; i < start + 15; i++) {
                bingoPool.add(c + String.valueOf(i));
                System.out.println(c + String.valueOf(i));
            }
            start += 15;
        }

        Collections.shuffle(bingoPool);

        for (int i = 0; i < 15; i++) {
            System.out.println(bingoPool.get(i));
        }

        System.out.println("-------------------------------");

        List<String> firstFifteen = new ArrayList<>(bingoPool.subList(0, 15));
        firstFifteen.sort(Comparator.naturalOrder());
        firstFifteen.replaceAll(s -> {
            if (s.indexOf('G') == 0 || s.indexOf('O') == 0) {
                String updated = s.charAt(0) + "-" + s.substring(1);
                System.out.print(String.valueOf(updated) + " ");
                return updated;
            }
            return s;
        });
        System.out.println("\n-------------------------------");



        var tempStream = bingoPool.stream()
                .limit(15)
                .filter(s -> s.indexOf('G') == 0 || s.indexOf('O') == 0)
                .map(s -> s.charAt(0) + "-" + s.substring(1))
                .sorted();
//                .forEach(System.out::println);

        tempStream.forEach(s -> System.out.print(s + " "));


        // using array as a stream source //
        System.out.println("-------------------------------");
        System.out.println("Using array as a stream source");
        System.out.println("-------------------------------");
        String[] colors = {"red", "green", "blue", "yellow", "orange"};


        var first  = Arrays.stream(colors)
                .sorted(Comparator.reverseOrder());
                // .map(s -> s.toUpperCase());
                // .forEach(System.out::println);

        var second = Stream.of("cyan", "magenta", "white", "black")
                .sorted(Comparator.reverseOrder())
                .map(s -> s.toUpperCase());
                // .forEach(System.out::println);

        Stream.concat(first, second)
                .forEach(System.out::println);

        Map<Character, int[]> myMap = new LinkedHashMap<>();
        int bingoIndex = 1;

        for (char c : "BINGO".toCharArray()) {
            int[] numbers = new int[15];
            int labelNo = bingoIndex;
            Arrays.setAll( numbers, i -> i + labelNo);
            myMap.put(c, numbers);
            bingoIndex += 15;
        }

        myMap.entrySet()
                .stream()
                .map(e -> e.getKey() + " has range: " + e.getValue()[0] + " - " + e.getValue()[e.getValue().length - 1])
                .forEach(System.out::println);

        // infinite stream - limited to 10
        Random random = new Random();
        Stream.generate(() -> random.nextInt(2))
                .limit(10)
                .forEach(System.out::print);

        System.out.println("\n-------------------------------");

        // integer stream //
        IntStream.iterate(1, n -> n + 1)
                .filter(Main2::isPrime)
                .limit(20)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n-------------------------------");
        // infite stream - limited to 100 //
        IntStream.iterate(1, n -> n + 1)
                .limit(100)
                .filter(Main2::isPrime)
                .forEach(s -> System.out.print(s + " "));


        System.out.println("\n-------------------------------");
        // not infinite stream - iterator limited to 100 //
        IntStream.iterate(1, n -> n <= 100 , n -> n + 1)
                .filter(Main2::isPrime)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n-------------------------------");
        // stream with range //
        IntStream.range(1,100)
                .filter(Main2::isPrime)
                .forEach(s -> System.out.print(s + " "));

        System.out.println("\n-------------------------------");
        // stream with range closed  - includes 100 //
        IntStream.rangeClosed(1,100)
                .filter(Main2::isPrime)
                .forEach(s -> System.out.print(s + " "));

    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;
        return IntStream.rangeClosed(2, number / 2).noneMatch(i -> number % i == 0);
    }

}
