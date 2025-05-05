import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargestElement{
    // public static int kthElement(int nums[],int k){
    //     int n = nums.length;
    //     PriorityQueue<Integer> pq = new PriorityQueue<>();
    //     for(int i = 0;i<k;i++){
    //         pq.add(nums[i]);
    //     }
    //     for(int i = k;i<n;i++){
    //         if(nums[i] > pq.peek()){
    //             pq.poll();
    //             pq.add(nums[i]);
    //         }
    //     }
    //     return pq.peek();
    // }
    public static int kthElement(int nums[],int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int num : nums) {
            pq.add(num);
        }
        for(int i = 0;i<k-1;i++) {
            pq.poll();
        }
        return pq.peek();
    }
    public static void main(String[] args) {
        int nums[] = {4,5,10,2,6,8};
        int k = 4;
        System.out.println(kthElement(nums, k));
    }
}