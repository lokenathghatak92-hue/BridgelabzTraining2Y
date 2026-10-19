package Recursion;
import java.util.*;
public class Program1{
    public static void archit(int n) {
        if(n==10) {
        return ;
        }
    System.out.println("I am a topper "+n);
    archit(n+1);
    }
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
archit(1);
    }
    }
