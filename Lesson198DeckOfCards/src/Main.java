import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed deck", 4);

        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);

        deck.sort(sortingAlgorithm);
        Card.printDeck(deck, "Sorted deck", 4);

        Collections.reverse(deck);
        Card.printDeck(deck, "Reversed deck", 13);

        List<Card> kings = new ArrayList<>(deck.subList(4,8));
        Card.printDeck(kings, "Kings", 4);

        List<Card> aces = new ArrayList<>(deck.subList(48,52));
        Card.printDeck(aces, "Aces", 4);

        int subListIndex = Collections.indexOfSubList(deck, kings);
        System.out.println("Kings are at index: " + subListIndex);

        boolean containsKings = deck.containsAll(kings);
        System.out.println("Deck contains kings: " + containsKings);

        boolean disjoint = Collections.disjoint(kings, aces);
        System.out.println("Kings and Aces are disjoint: " + disjoint);

        disjoint = Collections.disjoint(deck, kings);
        System.out.println("Deck and Kings are disjoint: " + disjoint);

        Card.printDeck(deck);

        Collections.swap(deck, 0, 51);
        Card.printDeck(deck);

//        deck.sort(sortingAlgorithm);

        // Binary Search
        Card tenOfHearts = Card.getNumericCard(Card.Suit.HEART, 10);
        int index = Collections.binarySearch(deck, tenOfHearts, sortingAlgorithm);
        System.out.println("Index of 10 of Hearts: " + index);




    }
}
