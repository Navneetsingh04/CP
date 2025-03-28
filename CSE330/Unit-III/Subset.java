
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Subset {
    public static void subsetSum(int arr[],int index,int sum,List<Integer> ans ){
        int n = arr.length;
        if(index == n){
            ans.add(sum);
            return;
        }
        subsetSum(arr, index+1, sum+arr[index], ans);
        subsetSum(arr, index+1, sum,ans);
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3};
        List<Integer> ans = new ArrayList<>();
        subsetSum(arr, 0, 0,ans);
        Collections.sort(ans);
        System.out.println(ans);
    }
}