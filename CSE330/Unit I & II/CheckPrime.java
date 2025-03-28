import java.util.Scanner;

public class CheckPrime {
//     public static boolean checkPrime(int n) {
//     if (n <= 1) {
//         return false;
//     }
//     for (int i = 2; i <= Math.sqrt(n); i++) {
//         if (n % i == 0) {
//             return false;
//         }
//     }
//     return true;
// }
public static boolean checkPrime(int n){
    if(n<=1) return false;
    if(n<=3) return true;
    if(n%2 == 0 || n%3 == 0) return false;
    for(int i = 5;i*i<=n;i += 6){
        if(n%i == 0 || n%(i+2) == 0) return false;
    }
    return true;
} 
public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    System.out.print("Enter the number: "); 
    int n = s.nextInt();
    boolean ans = checkPrime(n);
    if(ans){
        System.out.println(n+" is a Prime Number");
    }
    else{
        System.out.println(n+" is a Not Prime Number");
    }
    s.close();
    }
}
