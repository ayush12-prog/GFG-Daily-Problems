class Solution {
    public int shortCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < V; i++) {
            int[] dist = new int[V];
            Arrays.fill(dist, -1);
            Queue<int[]> q = new LinkedList<>();
            dist[i] = 0;
            q.add(new int[]{i, -1});
            while (!q.isEmpty()) {
                int[] cur = q.poll();
                int node = cur[0], parent = cur[1];
                for (int nei : adj.get(node)) {
                    if (dist[nei] == -1) {
                        dist[nei] = dist[node] + 1;
                        q.add(new int[]{nei, node});
                    } else if (nei != parent) {
                        ans = Math.min(ans, dist[node] + dist[nei] + 1);
                    }
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}