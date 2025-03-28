
public class CheckPalindrome {
    public static boolean isPrime(int n){
        if(n<=1) return false;
        if(n<=3) return true;
        if( n%2 == 0 || n%3 == 0) return false;
        for(int i = 5;i*i<=n;i += 6){
            if(n%i == 0 || n%(i+2) == 0) return false;
        }
        return true;
    }
    public static int checkPalindrome(int n){
        if(n<=8 && n <= 11){
            return 11;
        }
        for(int x = 1;x<100000;x++){
            String s = Integer.toString(x);
            StringBuffer buffer = new StringBuffer(s);
            buffer.reverse();
            int y = Integer.parseInt(s+buffer.substring(1));
            if(y >= n && isPrime(x) == true){
                return y;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 121;
        System.out.println(checkPalindrome(n));
    }
}
