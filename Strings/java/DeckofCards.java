package Strings.java;

import java.util.Scanner;
public class DeckofCards {
    static String[] suits = {
            "Hearts", "Diamonds", "Clubs", "Spades"
    };
    static String[] ranks = {
            "2", "3", "4", "5", "6", "7",
            "8", "9", "10", "Jack", "Queen", "King", "Ace"
    };
    // Initialize the deck
    public static String[] initializeDeck() {
        String[] deck = new String[suits.length * ranks.length];
        int index = 0;

        for (String suit : suits) {
            for (String rank : ranks) {
                deck[index++] = rank + " of " + suit;
            }
        }

        return deck;
    }

    // Shuffle the deck
    public static String[] shuffleDeck(String[] deck) {
        for (int i = 0; i < deck.length; i++) {
            int randomCardNumber = i
                    + (int) (Math.random() * (deck.length - i));

            String temp = deck[i];
            deck[i] = deck[randomCardNumber];
            deck[randomCardNumber] = temp;
        }

        return deck;
    }

    // Distribute cards equally among players
    public static String[][] distributeCards(
            String[] deck, int numberOfPlayers) {

        if (numberOfPlayers <= 0
                || deck.length % numberOfPlayers != 0) {
            return null;
        }

        int cardsPerPlayer = deck.length / numberOfPlayers;
        String[][] players =
                new String[numberOfPlayers][cardsPerPlayer];

        for (int i = 0; i < deck.length; i++) {
            players[i / cardsPerPlayer][i % cardsPerPlayer] = deck[i];
        }

        return players;
    }

    // Display each player's cards
    public static void displayPlayers(String[][] players) {
        for (int i = 0; i < players.length; i++) {
            System.out.println("\nPlayer " + (i + 1) + ":");

            for (int j = 0; j < players[i].length; j++) {
                System.out.println(players[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int numberOfPlayers = sc.nextInt();

        String[] deck = initializeDeck();
        shuffleDeck(deck);

        String[][] players =
                distributeCards(deck, numberOfPlayers);

        if (players == null) {
            System.out.println(
                    "Invalid number of players. Choose a positive "
                            + "number that divides 52 evenly.");
        } else {
            System.out.println("Total cards: " + deck.length);
            System.out.println(
                    "Cards per player: " + players[0].length);

            displayPlayers(players);
        }

        sc.close();
    }
}