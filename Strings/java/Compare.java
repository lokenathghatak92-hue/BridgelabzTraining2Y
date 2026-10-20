
import java.util.*;
public class Compare{
    static int findLength(String s) {
        int count = 0;
        try {
            while (true) {
                s.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    static String[] splitText(String s) {
        int n = findLength(s);
        int words = 0;

        // Count the words
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ' && i > 0
                    && s.charAt(i - 1) != ' ') {
                words++;
            }
        }

        if (n > 0 && s.charAt(n - 1) != ' ') {
            words++;
        }

        // Store space indexes
        int[] spaces = new int[words + 1];
        int k = 0;

        spaces[k++] = -1;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == ' ' && i > 0
                    && s.charAt(i - 1) != ' ') {
                spaces[k++] = i;
            }
        }

        spaces[k] = n;

        // Extract words
        String[] result = new String[words];
        int index = 0;

        for (int i = 0; i < words; i++) {
            String word = "";

            for (int j = spaces[i] + 1; j < spaces[i + 1]; j++) {
                if (s.charAt(j) != ' ') {
                    word = word + s.charAt(j);
                }
            }

            if (!word.isEmpty()) {
                result[index++] = word;
            }
        }

        return Arrays.copyOf(result, index);
    }

    static boolean compareArrays(String[] a, String[] b) {
        if (a.length != b.length) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            if (!a[i].equals(b[i])) {
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = sc.nextLine();
        String[] userWords = splitText(text);
        String[] builtInWords = text.trim().split("\\s+");

        System.out.println("User-defined split: "
                + Arrays.toString(userWords));

        System.out.println("Built-in split: "
                + Arrays.toString(builtInWords));

        System.out.println("Arrays are equal: "
                + compareArrays(userWords, builtInWords));
        sc.close();
    }
}
