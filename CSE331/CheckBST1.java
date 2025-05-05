public class CheckBST1{
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
    static boolean isValid;
    public static void checkTree(TreeNode root,int min,int max){
        if(root == null) return;
        if(root.data <= min || root.data >= max){
            isValid = false;
            return;
        }                                                      
        checkTree(root.left,min,root.data);
        checkTree(root.right,root.data,max);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(7);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(9);
        root.right.left = new TreeNode(14);
        root.right.right = new TreeNode(17);
        isValid = true;
        checkTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.println(isValid);
    }
}