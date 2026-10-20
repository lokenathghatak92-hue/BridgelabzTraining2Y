package Strings.java;

import java.util.Scanner;
public class CharacterType {
    // Method to check character type
    public static String checkCharacter(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        // Check whether the character is a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check whether the character is a vowel
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to store characters and their types in a 2D array
    public static String[][] findCharacterTypes(String text) {
        String[][] result = new String[text.length()][2];

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            result[i][0] = String.valueOf(ch);
            result[i][1] = checkCharacter(ch);
        }

        return result;
    }

    // Method to display the 2D array in tabular format
    public static void displayTable(String[][] data) {
        System.out.println("\nCharacter\tType");
        System.out.println("---------------------------");

        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = input.nextLine();

        String[][] result = findCharacterTypes(text);

        displayTable(result);

        input.close();
    }
}