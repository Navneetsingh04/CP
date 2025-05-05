public class CheckBSTMorrisTraversal {
    static class TreeNode{
        int data;
        TreeNode left,right;
        TreeNode(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }
    public static boolean isBST(TreeNode root){
        TreeNode curr = root;
        TreeNode prev = null;

        while(curr != null){
            if(curr.left == null){
                if(prev != null && curr.data <= prev.data){
                    return false;
                }
                prev = curr;
                curr= curr.right;
            }
            else{
                TreeNode pre = curr.left;
                while(pre.right != null && pre.right != curr){
                    pre = pre.right;
                }
                if(pre.right == null){
                    pre.right = curr;
                    curr = curr.left;
                }
                else{
                    pre.right = null;
                    if(prev != null && curr.data <= prev.data){
                        return false;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }
        return true;
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
