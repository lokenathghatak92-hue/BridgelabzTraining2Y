package Strings.java;

import java.util.Scanner;
public class AnagramCheck {
    public static boolean areAnagrams(String first, String second) {
        if (first.length() != second.length()) return false;
        int[] freq = new int[256];
        for (int i = 0; i < first.length(); i++) {
            freq[first.charAt(i)]++;
            freq[second.charAt(i)]--;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first text: ");
        String first = sc.nextLine();

        System.out.print("Enter second text: ");
        String second = sc.nextLine();

        if (areAnagrams(first, second))
            System.out.println("The texts are anagrams.");
        else
            System.out.println("The texts are not anagrams.");

        sc.close();
    }
}