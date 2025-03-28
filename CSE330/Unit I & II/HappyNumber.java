
import java.util.HashSet;
import java.util.Set;
public class HappyNumber {
    public static boolean isHappyNumber(int n){
        Set<Integer> set = new HashSet<>();
        while(true){
            int sum = 0;
            while(n != 0){
                sum += Math.pow(n%10, 2);
                n = n/10;
            }
            if(sum == 1) return true;
            n = sum;
            if(set.contains(n)){
                return false;
            }
            set.add(n);
        }
    }

    // Approach 2: using the fact that a number is happy if and only if it ends in 1 or 7.
    // Time complexity: O(logn)
    // Space complexity: O(1)
    
    public static boolean isHappy(int n){
        while(n != 1 && n != 7 && n >9){
            int sum = 0;
            while(n>0){
                sum += Math.pow(n%10,2);
                n = n/10;
            }
            n = sum;
        }
        return (n == 1 || n == 7);
    }
    public static int nextHappyNumber(int n){
        n++;
        while(!isHappy(n)){
            n++;
        }
        return n;
    }
    public static void main(String[] args) {
        int n = 49;
        System.out.println(isHappyNumber(n));
    }
}