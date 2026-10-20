package Recursion;
import java.util.*;
public class Program6 {
    static int rev(int n){
        if(n==0){
            return 0;
        }
        return rev(n-1);
    }
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(rev(n-1));
    }
}
