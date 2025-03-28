import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortelementsByFrequency {
    // Approach 1: Using sorting 
    // Time Complexity: O(nlogn)
    // Space Complexity: O(n)
    public static List<Integer> sortElementsByFrequency(int arr[]){
        int n = arr.length;
        Arrays.sort(arr);

        List<int[]> freq = new ArrayList<>();
        int i = 0;

        while(i<n){
            int count = 1;
            while(i<n-1 && arr[i] == arr[i+1]){
                count++;
                i++;
            }
            freq.add(new int[]{arr[i],count});
            i++;
        }
        freq.sort((a,b) -> b[1] == a[1] ? a[0]-b[0] : b[1]- a[1]);

        List<Integer> ans = new ArrayList<>();
        for(int pair[] : freq){
            for(int j = 0;j<pair[1];j++){
                ans.add(pair[0]);
            }
        }
        return ans;
    }

    // Approach 2:  Using  HashMap
    
    public static List<Integer> sortElementsByFrequencyII(int arr[]){
        
        Map<Integer,Integer> map = new HashMap<>();

        for(int i : arr){
            map.put(i,map.getOrDefault(i, 0)+1);
        }
        List<int[]> freq = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            freq.add(new int[]{entry.getKey(),entry.getValue()});
        }

        freq.sort((a,b) -> b[1]==a[1] ? a[0]-b[0] : b[1]-a[1]);

        List<Integer> ans = new ArrayList<>();
        for(int pair[] : freq){
            ans.addAll(Collections.nCopies(pair[1],pair[0]));
        }
        return ans;
    }
    public static void main(String[] args) {
        int arr[] = {2, 5, 2, 8, 5, 6, 8, 8};
        System.out.println(sortElementsByFrequency(arr));
        System.out.println(sortElementsByFrequencyII(arr));
    }
}
