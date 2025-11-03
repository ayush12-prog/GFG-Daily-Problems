class Solution {
    public ArrayList<Integer> safeNodes(int V, int[][] edges) {
        List<List<Integer>> rev = new ArrayList<>();
        for (int i = 0; i < V; i++) rev.add(new ArrayList<>());
        int[] indeg = new int[V];
        for (int[] e : edges) {
            rev.get(e[1]).add(e[0]);
            indeg[e[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < V; i++) if (indeg[i] == 0) q.add(i);
        boolean[] safe = new boolean[V];
        while (!q.isEmpty()) {
            int cur = q.poll();
            safe[cur] = true;
            for (int nei : rev.get(cur)) {
                indeg[nei]--;
                if (indeg[nei] == 0) q.add(nei);
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < V; i++) if (safe[i]) ans.add(i);
        return ans;
    }
}