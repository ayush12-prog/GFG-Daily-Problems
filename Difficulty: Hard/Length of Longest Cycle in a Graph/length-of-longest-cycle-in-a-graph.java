class Solution {
    public int longestCycle(int V, int[][] edges) {
        int[] adj = new int[V];
        Arrays.fill(adj, -1);
        
        for (int[] edge : edges) {
            adj[edge[0]] = edge[1];
        }
        
        boolean[] visited = new boolean[V];
        int maxCycleLength = -1;
        
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                HashMap<Integer, Integer> pathDist = new HashMap<>();
                int curr = i;
                int dist = 0;
                
                while (curr != -1 && !visited[curr]) {
                    visited[curr] = true;
                    pathDist.put(curr, dist++);
                    curr = adj[curr];
                }
                
                if (curr != -1 && pathDist.containsKey(curr)) {
                    int cycleLength = dist - pathDist.get(curr);
                    maxCycleLength = Math.max(maxCycleLength, cycleLength);
                }
            }
        }
        
        return maxCycleLength;
    }
}