import java.util.Stack;

public class InOrderItrative {
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
    public static void inOrder(TreeNode root){
        Stack<TreeNode> st = new Stack<>();
        while(root != null || !st.isEmpty()){
            while(root != null){
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            System.out.print(root.data+" ");
            root = root.right;
        }
    }
   public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        inOrder(root);
    } 
}
