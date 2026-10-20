package Recursion;
import java.util.*;
import java.util.*;
class Acronym {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<String> words = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            words.add(sc.next());
        }
        String s = sc.next();
        System.out.println(isAcronym(words, s));
        sc.close();
    }
    public static boolean isAcronym(List<String> words, String s) {
        if (s.length() != words.size()) return false;
        for (int i = 0; i < words.size(); i++) {
            if (words.get(i).charAt(0) != s.charAt(i)) return false;
        }
        return true;
    }
}