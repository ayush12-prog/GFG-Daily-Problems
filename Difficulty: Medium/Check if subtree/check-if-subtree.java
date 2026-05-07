/*
Definition for Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int x) {
        data = x;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSubTree(Node root1, Node root2) {
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        
        if (isIdentical(root1, root2)) {
            return true;
        }
        
        return isSubTree(root1.left, root2) || isSubTree(root1.right, root2);
    }
    
    private boolean isIdentical(Node node1, Node node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        
        return (node1.data == node2.data) 
            && isIdentical(node1.left, node2.left) 
            && isIdentical(node1.right, node2.right);
    }
}