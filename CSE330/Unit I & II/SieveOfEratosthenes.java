import java.util.Scanner;

public class SieveOfEratosthenes {
    public static void fun(int n) {
        int arr[] = new int[n + 1];
        for(int i = 2; i <= n; i++){
            arr[i] = i;
        }
        for(int p = 2; p*p <= n; p++){
            if(arr[p] != 0) { 
                for(int i = p*p; i<=n; i += p){
                    arr[i] = 0;
                }
            }
        }
        for(int i = 2; i <= n; i++){
            if (arr[i] != 0) {
                System.out.print(arr[i]+" ");
            }
        }
    }
    public static void main(String[] args) {
        try (Scanner s = new Scanner(System.in)) {
            System.out.print("Enter the number: ");
            int n = s.nextInt();
            fun(n);  
        }
    }
}
