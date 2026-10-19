package Recursion;
import java.util.*;
public class Program4 {
    static void reverseArrayRec(int[] arr, int i,int j) {
        if(i>=j) return;
        else {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
        reverseArrayRec(arr,i+1,j-1);
    }

    static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
       reverseArrayRec(arr,0,n-1);
        System.out.println(Arrays.toString(arr));
    }
}
