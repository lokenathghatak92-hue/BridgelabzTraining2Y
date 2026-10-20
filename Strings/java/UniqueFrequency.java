package Strings.java;

import java.util.Scanner;
public class UniqueFrequency {
    public static char[] uniqueCharacters(String text) {
        char[] temp = new char[text.length()];
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            boolean found = false;
            for (int j = 0; j < count; j++) {
                if (temp[j] == text.charAt(i)) {
                    found = true;
                    break;
                }
            }

            if (!found) temp[count++] = text.charAt(i);
        }

        char[] unique = new char[count];
        for (int i = 0; i < count; i++) {
            unique[i] = temp[i];
        }
        return unique;
    }

    public static String[][] findFrequency(String text) {
        char[] unique = uniqueCharacters(text);
        String[][] result = new String[unique.length][2];

        for (int i = 0; i < unique.length; i++) {
            int count = 0;

            for (int j = 0; j < text.length(); j++) {
                if (unique[i] == text.charAt(j)) count++;
            }

            result[i][0] = String.valueOf(unique[i]);
            result[i][1] = String.valueOf(count);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String[][] result = findFrequency(text);

        System.out.println("Character\tFrequency");
        for (String[] row : result) {
            System.out.println(row[0] + "\t\t" + row[1]);
        }

        sc.close();
    }
}
