/*
Anagram Partitioning

You are given a string s. Your task is to partition the string into the minimum number of contiguous substrings such that each substring is an anagram of at least one other substring in the partition.

In other words, after partitioning, every substring in the partition should have an anagram counterpart in the same partition. You need to minimize the total number of substrings.

Key Points: Anagram Condition: Two substrings are anagrams if they contain the exact same characters with the same frequencies, but in any order. Minimization: Your goal is to minimize the number of substrings formed after partitioning, ensuring that each substring is an anagram of at least one other substring. Efficiency: The solution should work efficiently for strings with lengths up to 10^5.

Input Format
Input is a string S.

Constraints
You must find the minimum number of partitions possible. The substrings can have any length, but each one must have at least one anagram in the final partition set.

Output Format
Output would be a single integer denoting minimum number of partition required of given string

Sample Input 0
abcabc
Output: 2
Sample Input 1
abcd
Output : 4

*/

import java.util.Arrays;

public class AnagramPartitioning {
    public static int minAnagramPatitions(String s){
        int n = s.length();
        int partitions = 0;
        int i = 0;
        while(i<n){
            boolean found = false;
            for(int len = (n-i)/2;len>=1;len--){
                if(i+len>n) break;
                String sub = s.substring(i,i+len);
                int[] freq = getFreq(sub);
                for(int j = i+len;j<=n-len;j++){
                    String sub2 = s.substring(j,j+len);
                    if(Arrays.equals(freq,getFreq(sub2))){
                        found = true;
                        partitions += 2; // Two substrings found
                        i = j+len; // Move the index to the end of the second substring
                        break;
                    }
                }
                if(found) break;
            }
            if(!found) partitions++;
            i++;
        }
        return partitions;
    }

    public static int[] getFreq(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }
    public static void main(String[] args) {
        String s = "abcd";
        int result = minAnagramPatitions(s);
        System.out.println(result); 
    }
}
