/*
class Node {
    int data;
    Node left, right;

    public Node(int d)
    {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    private int result;
    private int count;

    private void inorder(Node root) {
        if (root == null || count == 0) {
            return;
        }

        inorder(root.left);
        
        if (count > 0) {
            count--;
            if (count == 0) {
                result = root.data;
                return;
            }
        }

        inorder(root.right);
    }

    public int kthSmallest(Node root, int k) {
        this.count = k;
        this.result = -1; 
        inorder(root);
        return this.result;
    }
}

