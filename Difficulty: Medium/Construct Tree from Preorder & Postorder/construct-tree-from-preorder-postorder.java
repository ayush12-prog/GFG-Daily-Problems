/*
class Node {
    int data;
    Node left, right;

    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    private int preIndex = 0;
    private Map<Integer, Integer> postOrderMap;

    public Node constructTree(int[] pre, int[] post) {
        postOrderMap = new HashMap<>();
        for (int i = 0; i < post.length; i++) {
            postOrderMap.put(post[i], i);
        }
        
        return buildTree(pre, 0, post.length - 1);
    }

    private Node buildTree(int[] pre, int postStart, int postEnd) {
        if (postStart > postEnd || preIndex >= pre.length) {
            return null;
        }

        Node root = new Node(pre[preIndex]);
        preIndex++;

        if (postStart == postEnd) {
            return root;
        }

        int leftSubtreeRootVal = pre[preIndex];
        
        int postIndexOfLeftRoot = postOrderMap.get(leftSubtreeRootVal);

        root.left = buildTree(pre, postStart, postIndexOfLeftRoot);
        root.right = buildTree(pre, postIndexOfLeftRoot + 1, postEnd - 1);
        
        return root;
    }
}

