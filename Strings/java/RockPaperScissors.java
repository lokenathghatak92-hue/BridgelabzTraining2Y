package Strings.java;

import java.util.Scanner;
public class RockPaperScissors {
    // Method to generate computer choice
    public static String getComputerChoice() {
        int choice = (int) (Math.random() * 3);

        if (choice == 0) {
            return "Rock";
        } else if (choice == 1) {
            return "Paper";
        } else {
            return "Scissors";
        }
    }

    // Method to find the winner
    public static String findWinner(String player, String computer) {

        if (player.equals(computer)) {
            return "Draw";
        }

        if (player.equals("Rock") && computer.equals("Scissors")
                || player.equals("Paper") && computer.equals("Rock")
                || player.equals("Scissors") && computer.equals("Paper")) {
            return "Player";
        }

        return "Computer";
    }

    // Method to calculate wins and winning percentages
    public static String[][] calculateStats(
            int playerWins, int computerWins, int draws, int totalGames) {

        String[][] stats = new String[3][2];

        double playerPercentage = (double) playerWins / totalGames * 100;
        double computerPercentage = (double) computerWins / totalGames * 100;
        double drawPercentage = (double) draws / totalGames * 100;

        stats[0][0] = "Player";
        stats[0][1] = String.format("%.2f%%", playerPercentage);

        stats[1][0] = "Computer";
        stats[1][1] = String.format("%.2f%%", computerPercentage);

        stats[2][0] = "Draw";
        stats[2][1] = String.format("%.2f%%", drawPercentage);

        return stats;
    }

    // Method to display game results and statistics
    public static void displayResults(
            String[][] results, String[][] stats,
            int playerWins, int computerWins, int draws) {

        System.out.println("\nGame Results");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-10s %-12s %-12s %-10s%n",
                "Game", "Player", "Computer", "Winner");
        System.out.println("-----------------------------------------------");

        for (int i = 0; i < results.length; i++) {
            System.out.printf("%-10d %-12s %-12s %-10s%n",
                    i + 1, results[i][0], results[i][1], results[i][2]);
        }

        System.out.println("\nOverall Statistics");
        System.out.println("-----------------------------------------------");
        System.out.printf("%-12s %-12s %-15s%n",
                "Participant", "Wins", "Win Percentage");
        System.out.println("-----------------------------------------------");

        System.out.printf("%-12s %-12d %-15s%n",
                "Player", playerWins, stats[0][1]);
        System.out.printf("%-12s %-12d %-15s%n",
                "Computer", computerWins, stats[1][1]);
        System.out.printf("%-12s %-12d %-15s%n",
                "Draw", draws, stats[2][1]);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the number of games: ");
        int totalGames = input.nextInt();

        if (totalGames <= 0) {
            System.out.println("Please enter a positive number of games.");
            input.close();
            return;
        }

        String[][] results = new String[totalGames][3];

        int playerWins = 0;
        int computerWins = 0;
        int draws = 0;

        for (int i = 0; i < totalGames; i++) {
            System.out.println("\nGame " + (i + 1));
            System.out.print("Enter Rock, Paper, or Scissors: ");

            String player = input.next();

            // Validate player choice
            if (player.equalsIgnoreCase("Rock")) {
                player = "Rock";
            } else if (player.equalsIgnoreCase("Paper")) {
                player = "Paper";
            } else if (player.equalsIgnoreCase("Scissors")) {
                player = "Scissors";
            } else {
                System.out.println("Invalid choice. Try this game again.");
                i--;
                continue;
            }

            String computer = getComputerChoice();
            String winner = findWinner(player, computer);

            if (winner.equals("Player")) {
                playerWins++;
            } else if (winner.equals("Computer")) {
                computerWins++;
            } else {
                draws++;
            }

            results[i][0] = player;
            results[i][1] = computer;
            results[i][2] = winner;

            System.out.println("Computer chose: " + computer);
            System.out.println("Winner: " + winner);
        }

        String[][] stats = calculateStats(
                playerWins, computerWins, draws, totalGames);

        displayResults(results, stats,
                playerWins, computerWins, draws);

        input.close();
    }
}