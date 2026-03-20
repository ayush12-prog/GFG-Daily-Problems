class NodeValue {
    public int minNode, maxNode, maxSize;
    public boolean isBST;
    
    NodeValue(int minNode, int maxNode, int maxSize, boolean isBST) {
        this.minNode = minNode;
        this.maxNode = maxNode;
        this.maxSize = maxSize;
        this.isBST = isBST;
    }
}

class Solution {
    public int largestBst(Node root) {
        return largestBstHelper(root).maxSize;
    }
    
    private NodeValue largestBstHelper(Node node) {
        if (node == null) {
            return new NodeValue(Integer.MAX_VALUE, Integer.MIN_VALUE, 0, true);
        }
        
        NodeValue left = largestBstHelper(node.left);
        NodeValue right = largestBstHelper(node.right);
        
        if (left.isBST && right.isBST && node.data > left.maxNode && node.data < right.minNode) {
            return new NodeValue(
                Math.min(node.data, left.minNode),
                Math.max(node.data, right.maxNode),
                left.maxSize + right.maxSize + 1,
                true
            );
        }
        
        return new NodeValue(
            0, 
            0, 
            Math.max(left.maxSize, right.maxSize),
            false
        );
    }
}