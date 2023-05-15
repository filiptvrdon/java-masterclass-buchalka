import java.util.*;

public class Challenge {
    /*
    1. create a deck of cards
    2. shuffle the deck
    3. deal 5 cards to 2 players
    4. sort the cards in each player's hand
    5. print each player's hand with the cards in order, grouped by suit
    6. print each player's hand's score
    7. print the remaining deck
     */

    public static void main(String[] args) {
        // 1. create a deck of cards
        List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);

        // 2. shuffle the deck
        Collections.shuffle(deck);
        Card.printDeck(deck, "Shuffled deck", 4);

        // 3. deal 5 cards to 2 players
        List<Card> player1 = new ArrayList<>();
        List<Card> player2 = new ArrayList<>();

        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            player1.add(deck.remove(random.nextInt(deck.size())));
            player2.add(deck.remove(random.nextInt(deck.size())));
        }

        // 4. sort the cards in each player's hand
        var sortingAlgorithm = Comparator.comparing(Card::rank)
                .thenComparing(Card::suit);
        player1.sort(sortingAlgorithm);
        player2.sort(sortingAlgorithm);

        // 5. print each player's hand with the cards in order, grouped by suit
        Card.printDeck(player1, "Player 1", 4);
        Card.printDeck(player2, "Player 2", 4);

        // 6. print each player's hand's score
        System.out.println("Player 1 score: " + getScore(player1));
        System.out.println("Player 2 score: " + getScore(player2));

        // 7. print the remaining deck
        Card.printDeck(deck, "Remaining deck", 4);


    }

    private static String getScore(List<Card> hand) {
        int score = 0;
        for (Card card : hand) {
            score += card.rank();
        }
        return String.valueOf(score);
    }
}
