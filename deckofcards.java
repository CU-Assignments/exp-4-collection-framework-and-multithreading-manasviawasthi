import java.util.*;

class Card {
    String suit;
    String rank;

    public Card(String suit, String rank) {
        this.suit = suit;
        this.rank = rank;
    }

    @Override
    public String toString() {
        return rank + " of " + suit;
    }

    @Override
    public int hashCode() {
        return (suit + rank).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return suit.equals(card.suit) && rank.equals(card.rank);
    }
}

class DeckOfCards {
    private Map<String, Set<Card>> deck;

    public DeckOfCards() {
        deck = new HashMap<>();
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};

        // Initialize HashSet for each suit
        for (String suit : suits) {
            deck.put(suit, new HashSet<>());
        }

        // Populate the deck
        for (String suit : suits) {
            for (String rank : ranks) {
                deck.get(suit).add(new Card(suit, rank));
            }
        }
    }

    public Set<Card> getCardsBySuit(String suit) {
        return deck.getOrDefault(suit, new HashSet<>());
    }

    public void displayDeck() {
        for (String suit : deck.keySet()) {
            System.out.println(suit + ": " + deck.get(suit));
        }
    }
}

public class deckofcards {
    public static void main(String[] args) {
        DeckOfCards deck = new DeckOfCards();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a suit to search (Hearts, Diamonds, Clubs, Spades): ");
        String suit = scanner.nextLine();

        // Get the set of cards with the specified suit
        Set<Card> result = deck.getCardsBySuit(suit);

        // Display the results
        if (result.isEmpty()) {
            System.out.println("No cards found for the suit: " + suit);
        } else {
            System.out.println("Cards with the suit " + suit + ":");
            for (Card card : result) {
                System.out.println(card);
            }
        }

        scanner.close();
    }
}

