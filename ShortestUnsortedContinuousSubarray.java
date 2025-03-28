public class ShortestUnsortedContinuousSubarray {
    public static int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return 0;
        }
        int left = 0;
        int right = n-1;
        while(left < n-1 && nums[left] <= nums[left+1]){
            left++;
        }
        if(left == n-1){
            return 0;
        }
        while(right > 0 && nums[right] >= nums[right-1]){
            right--;
        }
        int subMini = Integer.MAX_VALUE;
        int subMaxi = Integer.MIN_VALUE;
        for(int i = left;i<=right;i++){
            subMini = Math.min(subMini,nums[i]);
            subMaxi = Math.max(subMaxi,nums[i]);
        }
        while(left > 0 && nums[left-1] > subMini){
            left--;
        }
        while(right < n-1 && nums[right+1] < subMaxi){
            right++;
        }
        return right-left+1;
    }
    public static void main(String[] args) {
        int nums[] = {2,6,4,8,10,9,15};
        System.out.println(findUnsortedSubarray(nums));
    }
}
