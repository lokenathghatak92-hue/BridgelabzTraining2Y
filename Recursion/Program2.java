package Recursion;
import java.util.*;
public class Program2 {
    public static int reverse(int n) {
        for (int i = n; i >= 0; i--) {
            System.out.println("the reverse of a number " + i);
        }
        if(n==0) {
            return n;
        }
        return n;
    }
public static void main(String[] args){
    Scanner sc=new Scanner(System.in);
    int n1=sc.nextInt();
    reverse(n1);
}
}
