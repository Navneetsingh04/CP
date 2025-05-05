import java.util.ArrayDeque;
import java.util.Queue;

public class LCAofBST {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    public static Node lowestCommonAncestor(Node root, Node p, Node q) {
        if(root == null) return null;
        if(p.data < root.data && q.data < root.data){
            Node leftAns = lowestCommonAncestor(root.left,p,q);
            return leftAns;
        }
        if(p.data > root.data && q.data > root.data){
            Node rightAns = lowestCommonAncestor(root.right,p,q);
            return rightAns;
        }
        return root;
    }
    public static Node lowestCommonAncestorI(Node root, Node p, Node q) {
        if(root == null || p == null || q == null) return root;
        while(true){
            if(p.data < root.data && q.data < root.data){
                root = root.left;
            }
            if(p.data > root.data && q.data > root.data){
               root = root.right;
            }
            else{
                return root;
            }
        }
    }
    public static void main(String[] args) {
        Node root = new Node(50);
        root.left = new Node(40);
        root.right = new Node(55);
        root.left.left = new Node(35);
        root.left.right = new Node(45);
        root.right.left = new Node(52);
        root.right.right = new Node(60);
        root.left.left.left = new Node(25);
        root.left.left.right = new Node(38);
        root.right.right.right = new Node(65);
        Node p = new Node(35);
        Node q = new Node(45);
        Node ans = lowestCommonAncestor(root, p, q);
        Node ans1 = lowestCommonAncestorI(root, p, q);
        System.out.println(ans.data);
        System.out.println(ans1.data);


    }
}
