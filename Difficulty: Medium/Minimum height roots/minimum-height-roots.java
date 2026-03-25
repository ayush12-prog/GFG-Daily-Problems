class Solution {
    public ArrayList<Integer> minHeightRoot(int V, int[][] edges) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Base case: If there is only one node, it is the root itself
        if (V == 1) {
            result.add(0);
            return result;
        }
        
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] degree = new int[V];
        
        // Build the graph and count degrees
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        
        // Add all initial leaf nodes (degree == 1) to the queue
        for (int i = 0; i < V; i++) {
            if (degree[i] == 1) {
                queue.offer(i);
            }
        }
        
        int remainingNodes = V;
        
        // Trim the leaves until 1 or 2 nodes are left
        while (remainingNodes > 2) {
            int size = queue.size();
            remainingNodes -= size;
            
            for (int i = 0; i < size; i++) {
                int leaf = queue.poll();
                
                // Update the neighbor
                for (int neighbor : adj.get(leaf)) {
                    degree[neighbor]--;
                    if (degree[neighbor] == 1) {
                        queue.offer(neighbor);
                    }
                }
            }
        }
        
        // The remaining nodes are the roots that yield the minimum height tree
        while (!queue.isEmpty()) {
            result.add(queue.poll());
        }
        
        // Sorting the result to match standard expected output formats
        Collections.sort(result);
        
        return result;
    }
}