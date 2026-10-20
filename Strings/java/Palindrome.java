package Strings.java;

import java.util.Scanner;
public class Palindrome {
    // Logic 1: Iterative comparison
    public static boolean isPalindrome(String text) {
        int start = 0;
        int end = text.length() - 1;
        while (start < end) {
            if (text.charAt(start) != text.charAt(end))
                return false;

            start++;
            end--;
        }

        return true;
    }

    // Logic 2: Recursive comparison
    public static boolean isPalindromeRecursive(
            String text, int start, int end) {
        if (start >= end) return true;

        if (text.charAt(start) != text.charAt(end))
            return false;

        return isPalindromeRecursive(text, start + 1, end - 1);
    }

    // Reverse using charAt()
    public static char[] reverse(String text) {
        char[] reversed = new char[text.length()];

        for (int i = 0; i < text.length(); i++) {
            reversed[i] = text.charAt(text.length() - 1 - i);
        }

        return reversed;
    }

    // Logic 3: Compare character arrays
    public static boolean isPalindromeArray(String text) {
        char[] original = text.toCharArray();
        char[] reversed = reverse(text);

        for (int i = 0; i < original.length; i++) {
            if (original[i] != reversed[i]) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        System.out.println("Iterative: " + isPalindrome(text));
        System.out.println("Recursive: "
                + isPalindromeRecursive(text, 0, text.length() - 1));
        System.out.println("Character array: " + isPalindromeArray(text));

        sc.close();
    }
}