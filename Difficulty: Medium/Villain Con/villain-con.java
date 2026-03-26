// User function Template for Java

class Solution {
    static int minColour(int N, int M, int mat[][]) {
        // Step 1: Build the adjacency list and indegree array
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] inDegree = new int[N + 1]; // 1-based indexing for minions
        
        for (int i = 0; i < M; i++) {
            int u = mat[i][0];
            int v = mat[i][1];
            adj.get(u).add(v); // Directed edge from u to v
            inDegree[v]++;
        }
        
        // Step 2: Initialize the queue with nodes having 0 indegree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int colors = 0;
        
        // Step 3: Process the graph level by level
        while (!queue.isEmpty()) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int curr = queue.poll();
                
                for (int neighbor : adj.get(curr)) {
                    inDegree[neighbor]--;
                    
                    if (inDegree[neighbor] == 0) {
                        queue.offer(neighbor);
                    }
                }
            }
            // Each level processed represents a new color required
            colors++;
        }
        
        return colors;
    }
}