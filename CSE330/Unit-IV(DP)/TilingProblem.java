/*
GFG: Ways To Tile A Floor

Given a floor of dimensions 2 x n and tiles of dimensions 2 x 1, the task is to find the number of ways the floor can be tiled. A tile can either be placed horizontally i.e as a 1 x 2 tile or vertically i.e as 2 x 1 tile. return the answer with modulo 10^9+7.

Example 1:

Input:
n = 3
Output: 3
Explanation:
We need 3 tiles to tile the boardof size  2 x 3. 
We can tile in following ways:
1) Place all 3 tiles vertically. 
2) Place first tile vertically and remaining 2 tiles horizontally.
3) Place first 2 tiles horizontally and remaining tiles vertically.
Example 2:

Input:
n = 4
Output:5
Explanation:
For a 2 x 4 board, there are 5 ways
1) All 4 vertical
2) All 4 horizontal
3) First 2 vertical, remaining 2 horizontal.
4) First 2 horizontal, remaining2 vertical.
5) Corner 2 vertical, middle 2 horizontal.


Constraints:
1 <= n <= 105
*/
public class TilingProblem {
    public static int numberOfWays(int n){
        int mod = (int)1e7;
        if(n <= 2){
            return n;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3;i<=n;i++){
            dp[i] = (dp[i-1]+dp[i-2])%mod;
        }
        return dp[n];
    }
    public static void main(String[] args) {
        int n = 4;
        System.out.println(numberOfWays(n));
    }
}