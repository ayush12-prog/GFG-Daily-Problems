class Solution {
    public int diameter(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        int farNode = bfs(0, adj)[0];
        int diameter = bfs(farNode, adj)[1];
        return diameter;
    }

    private int[] bfs(int start, List<List<Integer>> adj) {
        boolean[] vis = new boolean[adj.size()];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        vis[start] = true;
        int farNode = start, maxDist = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int node = cur[0], dist = cur[1];
            if (dist > maxDist) {
                maxDist = dist;
                farNode = node;
            }
            for (int nei : adj.get(node)) {
                if (!vis[nei]) {
                    vis[nei] = true;
                    q.add(new int[]{nei, dist + 1});
                }
            }
        }
        return new int[]{farNode, maxDist};
    }
}