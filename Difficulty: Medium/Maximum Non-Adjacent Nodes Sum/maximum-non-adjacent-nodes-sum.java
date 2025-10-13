/*
class Node {
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
*/

class Solution {
    
    public int[] solve(Node root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] leftSum = solve(root.left);
        int[] rightSum = solve(root.right);

        int robCurrent = root.data + leftSum[1] + rightSum[1];
        int dontRobCurrent = Math.max(leftSum[0], leftSum[1]) + Math.max(rightSum[0], rightSum[1]);

        return new int[]{robCurrent, dontRobCurrent};
    }

    public int getMaxSum(Node root) {
        if (root == null) {
            return 0;
        }
        int[] result = solve(root);
        return Math.max(result[0], result[1]);
    }
}
