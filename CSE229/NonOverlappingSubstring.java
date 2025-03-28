
import java.util.Arrays;

/*
Find out if two non-overlappingsubstrings of length-K from astring are anagrams of each other

In the challenge you have to find out if there are at least two substrings of length K in given input string that the both substrings areanagrams of each other. But both the substrings should be non-overlapping substrings.
Consider the string s="abcbca", here for K=3 there are two non-overlapping substrings s1="abc" and s2="bca" which are anagrams of each other.
Let we consider another example s="abcba", here also for K=3 substrings s1="abc" and s2="cba" are anagrams of each other but these substrings are overlapping as 'c' is the overlapping element between both substrings, so these substrings are not considered for the solution.

Input Format
1) First input consists of a string. 
2) Second input consists of an integer K.

Constraints
N/A
Output Format
Output of the program would be a "Yes" or "No". If there are atleast two non over-lapping K-length substrings in input string whichare anagrams then print "Yes" else print "No" .
Sample Input 0
abcdebeacd
5
Sample Output 0
Yes
Sample Input 1
abcaabcaa
3
Sample Output 1
Yes
Sample Input 2
aabcbaa

*/
public class NonOverlappingSubstring {
    public static boolean isAnagram(String str1,String str2){
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        Arrays.sort(ch1);
        Arrays.sort(ch2);
        return Arrays.equals(ch1, ch2);
    }
    public static String nonOverlappingAnangram(String str,int k){
        int n = str.length();
        for(int i = 0;i<=n-k;i++){
            String sub1 = str.substring(i,i+k);
            for(int j = i+1;j<=n-k;j++){
                String sub2 = str.substring(j,j+k);
                if(isAnagram(sub1, sub2)){
                    return "yes";
                }
            }
        }
        return "No";
    }
    public static void main(String[] args) {
        String str = "abcaabcaa";
        int k = 3;
        System.out.println(nonOverlappingAnangram(str, k));
    }
}


