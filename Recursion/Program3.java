package Recursion;
import java.util.*;
public class Program3 {
    static int sum(int n) {
        if (n < 10) {
            return n;
        }
        return sum(n % 10 + sum(n / 10));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sum(n));
    }
}
