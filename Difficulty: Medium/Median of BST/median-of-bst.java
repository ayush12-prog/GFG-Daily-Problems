/*
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {

    private int countNodes(Node root) {
        if (root == null) {
            return 0;
        }
        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    public int findMedian(Node root) {
        if (root == null) {
            return 0;
        }
        
        int n = countNodes(root);
        
        int k;
        if (n % 2 == 0) {
            k = n / 2;
        } else {
            k = (n + 1) / 2;
        }

        Deque<Node> stack = new ArrayDeque<>();
        Node current = root;
        int nodesVisited = 0;
        
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            
            current = stack.pop();
            
            nodesVisited++;
            
            if (nodesVisited == k) {
                return current.data;
            }
            
            current = current.right;
        }
        
        return -1;
    }
}