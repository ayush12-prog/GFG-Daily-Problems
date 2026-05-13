class Solution {

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (int next : adj.get(node)) {
            if (!vis[next]) {
                dfs(next, adj, vis);
            }
        }
    }

    public int findMotherVertex(int V, int[][] edges) {

        // Build graph
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
        }

        // Step 1: Find candidate
        boolean[] vis = new boolean[V];
        int candidate = -1;

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                candidate = i;
            }
        }

        // Step 2: Verify candidate
        vis = new boolean[V];
        dfs(candidate, adj, vis);

        for (boolean reached : vis) {
            if (!reached) {
                return -1;
            }
        }

        // Step 3: Find smallest mother vertex
        for (int i = 0; i <= candidate; i++) {

            vis = new boolean[V];
            dfs(i, adj, vis);

            boolean ok = true;

            for (boolean reached : vis) {
                if (!reached) {
                    ok = false;
                    break;
                }
            }

            if (ok) {
                return i;
            }
        }

        return candidate;
    }
}