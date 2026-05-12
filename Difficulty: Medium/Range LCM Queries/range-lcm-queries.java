class Solution {
    public ArrayList<Long> RangeLCMQuery(int[] arr, int[][] queries) {
        int n = arr.length;
        long[] tree = new long[4 * n];
        build(arr, tree, 0, 0, n - 1);
        
        ArrayList<Long> res = new ArrayList<>();
        for (int[] q : queries) {
            if (q[0] == 1) {
                update(tree, 0, 0, n - 1, q[1], q[2]);
            } else if (q[0] == 2) {
                res.add(query(tree, 0, 0, n - 1, q[1], q[2]));
            }
        }
        return res;
    }
    
    private void build(int[] arr, long[] tree, int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = start + (end - start) / 2;
            build(arr, tree, 2 * node + 1, start, mid);
            build(arr, tree, 2 * node + 2, mid + 1, end);
            tree[node] = lcm(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }
    
    private void update(long[] tree, int node, int start, int end, int idx, int val) {
        if (start == end) {
            tree[node] = val;
        } else {
            int mid = start + (end - start) / 2;
            if (start <= idx && idx <= mid) {
                update(tree, 2 * node + 1, start, mid, idx, val);
            } else {
                update(tree, 2 * node + 2, mid + 1, end, idx, val);
            }
            tree[node] = lcm(tree[2 * node + 1], tree[2 * node + 2]);
        }
    }
    
    private long query(long[] tree, int node, int start, int end, int l, int r) {
        if (r < start || end < l) {
            return 1;
        }
        if (l <= start && end <= r) {
            return tree[node];
        }
        int mid = start + (end - start) / 2;
        long leftLcm = query(tree, 2 * node + 1, start, mid, l, r);
        long rightLcm = query(tree, 2 * node + 2, mid + 1, end, l, r);
        return lcm(leftLcm, rightLcm);
    }
    
    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    
    private long lcm(long a, long b) {
        if (a == 0 || b == 0) return 0;
        return (a / gcd(a, b)) * b;
    }
}