package Recursion;
/*import java.util.*;
public class Fibonacchi{
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int a=0,b=1,c=1;
        int sum=0;
  for(int i=0;i<=n;i++){
      sum=a+b;
      System.out.println("The fibonacchi sequence--"+sum);
      a=b;
      b=sum;
  }
    }
}*/
import java.util.*;
public class Fibonacchi{
    static int  fib(int n) {
        if (n <= 1) {
            return n;
        }
        return fib(n-1)+fib(n-2);
    }
    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        for(int i=0;i<n;i++) {
            System.out.println("The required fibonacchi sequence "+fib(i));
        }
    }
}
