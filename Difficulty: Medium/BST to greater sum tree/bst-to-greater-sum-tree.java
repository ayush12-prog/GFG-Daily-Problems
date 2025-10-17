/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
} */

class Solution {
    public Node transformTree(Node root) {
        if (root == null) {
            return null;
        }

        int sum = 0;
        Deque<Node> stack = new ArrayDeque<>(); 
        Node current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.right;
            }
            current = stack.pop();
            
            int originalValue = current.data;
            current.data = sum;
            sum += originalValue;

          
            current = current.left;
        }
        
        return root;
    }
}