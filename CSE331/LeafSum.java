import java.util.ArrayDeque;
import java.util.Queue;

public class LeafSum {
    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    // Approach 1: Recursive Approach
    // Time Complexity: O(n)
    // Space Complexity: O(n)

    static int sum = 0;
    public static void leafSum(TreeNode root,int currSum){
        if(root == null) return;
        currSum = currSum*10+root.data;
        if(root.left == null && root.right == null){
            sum += currSum;
        }
        leafSum(root.left,currSum);
        leafSum(root.right,currSum);
    }
    // Approach 1: Itrative using bfs
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public static void bfs(TreeNode root){
        int sum = 0;
        Queue<TreeNode> queue = new ArrayDeque<>();
        Queue<Integer> currSum = new ArrayDeque<>();
        queue.add(root);
        currSum.add(root.data);
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            int currentSum = currSum.poll();
            if(curr.left == null && curr.right == null){
                sum = sum+currentSum;
            }
            if(curr.left != null){
                queue.add(curr.left);
                currSum.add(currentSum*10+curr.left.data);
            }
            if(curr.right != null){
                queue.add(curr.right);
                currSum.add(currentSum*10+curr.right.data);
            }
        }
        System.out.println(sum);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(1);
        leafSum(root, 0);
        System.out.println(sum);
        bfs(root);
    }
}
