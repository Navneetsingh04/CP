// Time Complexity: O(log(n))
public class CountGoodNumbers {
    public static long modPow(long x,long n){
        long ans = 1;
        long mod = (long)1e9+7;
        while(n>0){
            if((n&1) == 1){
                ans = (ans*x)%mod;
            }
            n = n/2;
            x = (x*x)%mod;
        }
        return ans;
    }
    public static int countGoodNumber(long n){
        long mod = (long)1e9+7;
        long even,odd;
        // dteremine the count of even and odd position
        if((n&1) == 1){
            even = (n/2)+1;
            odd = n/2;
        }
        else{
            even = odd = n/2;
        }
        long evenPower = modPow(5,even);
        long oddPower = modPow(4,odd);
        return (int)((evenPower*oddPower)%mod);
    }
    public static void main(String[] args) {
        long n = 50;
        System.out.println(countGoodNumber(n));
    }
}
