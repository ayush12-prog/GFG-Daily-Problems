class Solution {
    static class Node {
        Node[] child = new Node[2];
        int count = 0;
    }

    private void insert(Node root, int num) {
        for (int i = 15; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (root.child[bit] == null) root.child[bit] = new Node();
            root = root.child[bit];
            root.count++;
        }
    }

    private int countLess(Node root, int num, int k) {
        int res = 0;
        for (int i = 15; i >= 0 && root != null; i--) {
            int nb = (num >> i) & 1;
            int kb = (k >> i) & 1;

            if (kb == 1) {
                if (root.child[nb] != null) res += root.child[nb].count;
                root = root.child[nb ^ 1];
            } else {
                root = root.child[nb];
            }
        }
        return res;
    }

    public int cntPairs(int[] arr, int k) {
        Node root = new Node();
        int ans = 0;

        for (int x : arr) {
            ans += countLess(root, x, k);
            insert(root, x);
        }

        return ans;
    }
}
