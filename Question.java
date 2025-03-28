//  Sort Elements by Decreasing Frequency

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    public static List<Integer> sieve(int limit){
        int prime[] = new int[limit+1];
        List<Integer> primes = new ArrayList<>();
        Arrays.fill(prime, 1);
        prime[0] = prime[1] = 0;

        for(int i= 2;i*i<=limit;i++){
            if(prime[i] == 1){
                for(int j = i*i;j<= limit;j += i){
                    prime[j] = 0;
                }
            }
        }
        for(int i = 2;i<=limit;i++){
            if(prime[i] == 1){
                primes.add(i);
            }
        }
        return primes;
    }
    public static List<Integer> segmentedSieve(int l,int r){
        int limit = (int)Math.sqrt(r);
        List<Integer> primes = sieve(limit);

        int dummy[] = new int[r-l+1];
        Arrays.fill(dummy,1);
        if(l == 1){
            dummy[0] = 0;
        }
        for(int i : primes){
           int firstMultiple = (l/i)*i;
           if(firstMultiple < l) firstMultiple += i;
           for(int j = Math.max(firstMultiple,i*i);j<=r;j+= i){
                dummy[j-l] = 0;
           }
        }
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<dummy.length;i++){
			if(dummy[i] == 1){
				ans.add(l+i);
			}
		}
        return ans;
    }
    public static void main(String[] args) {
        int l = 110;
        int r = 200;
        List<Integer> ans = segmentedSieve(l,r);
        System.out.println(ans);
    }
}
