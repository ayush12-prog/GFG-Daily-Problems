/* Structure for Tree Node
class Node {
    int data;
    Node left, right;

    // Constructor
    Node(int val) {
        data = val;
        left = null;
        right = null;
    }
};
*/
class Solution {
    public void toSumTree(Node root) {
        computeSum(root);
    }
    
    private int computeSum(Node node) {
        if (node == null) {
            return 0;
        }
        
        int oldVal = node.data;
        
        int leftSum = computeSum(node.left);
        int rightSum = computeSum(node.right);
        
        node.data = leftSum + rightSum;
        
        return oldVal + node.data;
    }
}