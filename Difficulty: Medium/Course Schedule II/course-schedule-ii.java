class Solution {
    public ArrayList<Integer> findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indeg = new int[n];
        for (int[] pre : prerequisites) {
            adj.get(pre[1]).add(pre[0]);
            indeg[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) if (indeg[i] == 0) q.add(i);
        ArrayList<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            for (int nei : adj.get(cur)) {
                indeg[nei]--;
                if (indeg[nei] == 0) q.add(nei);
            }
        }
        if (order.size() != n) return new ArrayList<>();
        return order;
    }
}