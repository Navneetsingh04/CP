import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    static class Node{
        Node left;
        Node right;
        int data;

        Node(int data){
            this.data = data;
            left = null;
            right = null;
        }
    }

    // Approach 1: BFS

    public static void rightViewI(Node root){
        if(root == null){
            return;
        }
        Queue<Node> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Node curr = queue.poll();
                if(i == size-1){
                    list.add(curr.data);
                }
                if(curr.left != null) queue.add(curr.left);
                if(curr.right != null) queue.add(curr.right);
            }
        }
        System.out.println(list);
    }

    // Approach 2: DFS

    public static void rightView(Node root,List<Integer> ans,int currDepth){
        if(root == null) return;
        if(currDepth == ans.size()){
            ans.add(root.data);
        }
        rightView(root.right,ans,currDepth+1);
        rightView(root.left,ans,currDepth+1);
    }
    
    public static List<Integer> rightView(Node root){
        List<Integer> ans = new ArrayList<>();
        rightView(root,ans,0);
        return ans;
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(2);
        root.left.right = new Node(40);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.right.right.left = new Node(5);
        root.left.right.left.right = new Node(8);
        root.right.right.right = new Node(6);
        List<Integer> ans = rightView(root);
        System.out.println(ans);
        rightViewI(root);
    }
}