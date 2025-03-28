public class FermatLittleTheorem {
    public static long powerMod(long base, long exp, long mod){
        long result = 1;
        base = base % mod;   // Reduce base if it is larger than mod
        while(exp > 0){
            if((exp & 1) == 1) { // If exp is odd, multiply base with result
                result = (result * base) % mod; 
            }
            base = (base * base) % mod; // Square the base
            exp = exp >> 1; // Divide exp by 2
        }
        return result;
    }

    public static long modeInverse(long a, long p){
        if(a % p == 0){
            System.out.println("Inverse does not exist as a is divisible by p");
            return -1; // Indicating no inverse exists
        }
        return powerMod(a, p - 2, p);  // Fermat’s method: a^(p-2) % p
    }

    public static void main(String[] args) {
        long a = 3; // base
        long p = 7; // prime number
        
        // Fermat's Little Theorem: a^(p-1) ≡ 1 (mod p)
        long result = powerMod(a,p-1,p);
        
        System.out.println("Result: " + result); // should be 1 if p is prime
    }
}
