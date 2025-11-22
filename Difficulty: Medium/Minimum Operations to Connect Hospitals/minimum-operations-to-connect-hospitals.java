class Solution {
    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    void union(int a, int b) {
        int pa = find(a), pb = find(b);
        if (pa == pb) return;
        if (rank[pa] < rank[pb]) parent[pa] = pb;
        else if (rank[pa] > rank[pb]) parent[pb] = pa;
        else {
            parent[pb] = pa;
            rank[pa]++;
        }
    }

    public int minConnect(int V, int[][] edges) {
        int E = edges.length;
        if (E < V - 1) return -1;

        parent = new int[V];
        rank = new int[V];

        for (int i = 0; i < V; i++) parent[i] = i;

        for (int[] e : edges) union(e[0], e[1]);

        int components = 0;
        for (int i = 0; i < V; i++) if (find(i) == i) components++;

        return components - 1;
    }
}
