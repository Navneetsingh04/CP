import java.util.ArrayDeque;
import java.util.Queue;

public class CheckCousin {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node parentX = null;
    Node parentY = null;
    int levelX = -1, levelY = -1;

    // DFS Soluion 
    // T.C: O(n)
    // T.C: O(h)

    public boolean isCousinsDFS(Node root, int x, int y) {
        if (root == null) return false;
        findParentLevel(root, null, x, y, 0);
        return (parentX != parentY && levelX == levelY);
    }
    public void findParentLevel(Node root, Node parent, int x, int y, int level) {
        if (root == null)
            return;
        if (root.data == x) {
            parentX = parent;
            levelX = level;
        }
        if (root.data == y) {
            parentY = parent;
            levelY = level;
        }
        findParentLevel(root.left, root, x, y, level + 1);
        findParentLevel(root.right, root, x, y, level + 1);
    }
    public boolean isCousinsBFS(Node root,int x,int y){
        if(root == null) return false;
        Queue<Node> queue = new ArrayDeque<>();
        boolean xFound = false;
        boolean yFound = false;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                Node currNode = queue.poll();
                if(currNode.left != null && currNode.right != null){
                    if((currNode.left.data == x && currNode.right.data == y) || (currNode.left.data == y && currNode.right.data == x));
                    xFound = false;
                    break;
                }
                if(currNode.left != null){
                    if(currNode.left.data == x) xFound = true;
                    if(currNode.left.data == y) yFound = true;
                    queue.add(currNode.left);
                }
                if(currNode.right != null){
                    if (currNode.right.data == x) xFound = true;
                    if (currNode.right.data == y) yFound = true;
                    queue.add(currNode.right);
                }
            }
            if(xFound && yFound) return true;
            if(xFound || yFound) return false; 
        }
        return false;
    }
    public static void main(String[] args) {
        CheckCousin obj = new CheckCousin();
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(2);
        root.left.right = new Node(40);
        root.right.right = new Node(4);
        root.left.right.left = new Node(7);
        root.right.right.left = new Node(5);
        int x = 40, y = 7;
        System.out.println(obj.isCousinsDFS(root, x, y));
        System.out.println(obj.isCousinsBFS(root,x,y));
    }
}
