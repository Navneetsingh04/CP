import java.util.Arrays;
import java.util.PriorityQueue;

public class SortNearlySortedArray {
    public static void nearlySorted(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int index = 0;
        for(int i = 0;i<arr.length;i++){
            minHeap.add(arr[i]);
            if(minHeap.size() > k){
                arr[index++] = minHeap.poll();
            }
        }
        while(!minHeap.isEmpty()){
            arr[index++] = minHeap.poll();
        }
    }
    public static void main(String[] args) {
        int arr[] = {6, 5, 3, 2, 8, 10, 9};
        int k = 3;
        nearlySorted(arr, k);
        System.out.println(Arrays.toString(arr));
    }
}
