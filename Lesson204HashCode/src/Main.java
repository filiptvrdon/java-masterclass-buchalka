import java.util.*;

public class Main {
    public static void main(String[] args) {


        String aText =  "Hello";
        String bText =  "Hello";
        String cText =  String.join("l", "He", "lo");
        String dText =  "Hel" + "lo";
        String eText =  "hello";

        List<String> hellos = Arrays.asList(aText, bText, cText, dText, eText);

        hellos.forEach(s -> System.out.println(s + ": " + s.hashCode()));

        Set<String> mySet = new HashSet<>(hellos);
        System.out.println("Set: " + mySet);
        System.out.println("Set size: " + mySet.size());

        for (String s : mySet) {
            System.out.println(s + ": " + s.hashCode());
        }


        PlayingCard aceOfSpades = new PlayingCard("Spades", "Ace");
        PlayingCard kingOfClubs = new PlayingCard("Clubs", "King");
        PlayingCard queenOfHearts = new PlayingCard("Hearts", "Queen");

        List<PlayingCard> cards = Arrays.asList(aceOfSpades, kingOfClubs, queenOfHearts);
        cards.forEach(c -> System.out.println(c + ": " + c.hashCode()));
        System.out.println("--------------------");

        Set<PlayingCard> deck = new HashSet<>(cards);
        for (PlayingCard c : deck) {
            System.out.println(c + ": " + c.hashCode());
        }

    }
}