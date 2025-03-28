
import java.util.Arrays;
public class LongestCommonSubsequenece {
    public static int longestSubsequenec(String s1,String s2,int n,int m,int dp[][]){
        if(n == 0 || m == 0){
            return 0;
        }
        if(dp[n][m] != -1){
            return dp[n][m];
        }
        if(s1.charAt(n-1) == s2.charAt(m-1)){
            return 1+longestSubsequenec(s1, s2,n-1,m-1,dp);
        }
        dp[n][m] = Math.max(longestSubsequenec(s1, s2, n-1, m,dp),longestSubsequenec(s1, s2, n, m-1,dp));
        return dp[n][m];   
    }
    public static void main(String[] args) {
        String s1 = "abaaba";
        String s2 = "babbab";
        int n = s1.length();
        int m = s2.length();
        int dp[][] = new int[n+1][m+1];
        for(int i[] : dp){
            Arrays.fill(i,-1);
        }
        System.out.println(longestSubsequenec(s1, s2, n, m,dp));
    }
}
