package Strings.java;

import java.util.Scanner;
public class UniqueCharacters {
    public static int findLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            // End of string
        }
        return count;
    }

    public static char[] uniqueCharacters(String text) {
        int n = findLength(text);
        char[] temp = new char[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            char ch = text.charAt(i);
            boolean found = false;

            for (int j = 0; j < count; j++) {
                if (temp[j] == ch) {
                    found = true;
                    break;
                }
            }

            if (!found) {
                temp[count] = ch;
                count++;
            }
        }
        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        char[] result = uniqueCharacters(text);

        System.out.print("Unique characters: ");
        for (char ch : result) {
            System.out.print(ch + " ");
        }
        sc.close();
    }
}