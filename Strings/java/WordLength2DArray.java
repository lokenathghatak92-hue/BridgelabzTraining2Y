package Strings.java;

import java.util.Scanner;
public class WordLength2DArray {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of the string
        }

        return count;
    }

    // Method to split text into words using charAt()
    public static String[] splitWords(String text) {
        int textLength = findLength(text);
        int wordCount = 0;
        boolean inWord = false;

        // Count the number of words
        for (int i = 0; i < textLength; i++) {
            if (text.charAt(i) != ' ' && !inWord) {
                wordCount++;
                inWord = true;
            } else if (text.charAt(i) == ' ') {
                inWord = false;
            }
        }

        String[] words = new String[wordCount];
        String word = "";
        int index = 0;

        // Extract words from the text
        for (int i = 0; i < textLength; i++) {
            char ch = text.charAt(i);

            if (ch != ' ') {
                word = word + ch;
            } else if (!word.equals("")) {
                words[index] = word;
                index++;
                word = "";
            }
        }

        // Store the last word, if present
        if (!word.equals("")) {
            words[index] = word;
        }

        return words;
    }

    // Method to create a 2D array of words and their lengths
    public static String[][] getWordLengths(String[] words) {
        String[][] result = new String[words.length][2];

        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(findLength(words[i]));
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = input.nextLine();

        String[] words = splitWords(text);
        String[][] result = getWordLengths(words);

        System.out.println("\nWord\t\tLength");
        System.out.println("----------------------");

        for (int i = 0; i < result.length; i++) {
            int length = Integer.parseInt(result[i][1]);
            System.out.println(result[i][0] + "\t\t" + length);
        }

        input.close();
    }
}