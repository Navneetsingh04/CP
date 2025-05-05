// import java.util.ArrayList;
public class ChekBST {
    static class TreeNode{
        int  data;
        TreeNode left;
        TreeNode right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Approach 1: Inorder Travresal and List
    // T.C: O(N)
    // S.C: O(H)

    // public static void inOrder(TreeNode root,ArrayList<Integer> list){
    //     if(root == null) return;
    //     inOrder(root.left, list);
    //     list.add(root.data);
    //     inOrder(root.right, list);
    // }
    // public static boolean isBST(TreeNode root){
    //     ArrayList<Integer> list = new ArrayList<>();
    //     inOrder(root, list);
    //     for(int i = 1;i<list.size();i++){
    //         if(list.get(i) <= list.get(i-1)){
    //             return false;
    //         }
    //     }
    //     return true;
    // }

    // Approach 2nd: Inoreder Traversal 


    static TreeNode prev = null;
    public static boolean isBST(TreeNode root){
        if(root == null) return true;
        if(!isBST(root.left)) return false;
        if(prev != null && root.data <= prev.data){
            return false;
        }
        prev = root;
        return isBST(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(11);
        root.right.right = new TreeNode(17);
        System.out.println(isBST(root));
    }
}
