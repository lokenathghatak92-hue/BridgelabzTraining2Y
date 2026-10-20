package Strings.java;

import java.util.Scanner;
public class VowelConsonantCount {
    // Method to check whether a character is a vowel,
    // consonant, or not a letter
    public static String checkCharacter(char ch) {
        // Convert uppercase to lowercase using ASCII values
        if (ch >= 'A' && ch <= 'Z') {
            ch = (char) (ch + 32);
        }
        // Check whether the character is a letter
        if (ch >= 'a' && ch <= 'z') {
            // Check for vowels
            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                return "Vowel";
            } else {
                return "Consonant";
            }
        }

        return "Not a Letter";
    }

    // Method to count vowels and consonants in a string
    public static int[] countVowelsConsonants(String text) {
        int vowels = 0;
        int consonants = 0;
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            String result = checkCharacter(ch);
            if (result.equals("Vowel")) {
                vowels++;
            } else if (result.equals("Consonant")) {
                consonants++;
            }
        }
        return new int[] {vowels, consonants};
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String text = input.nextLine();
        int[] count = countVowelsConsonants(text);
        System.out.println("Vowel count: " + count[0]);
        System.out.println("Consonant count: " + count[1]);
        input.close();
    }
}