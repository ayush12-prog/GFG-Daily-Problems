class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        
        int[] indegree = new int[n];
        
        // Build the adjacency list and indegree array
        for (int[] pre : prerequisites) {
            int course = pre[0];
            int prereq = pre[1];
            
            adj.get(prereq).add(course);
            indegree[course]++;
        }
        
        // Add all courses with no prerequisites to the queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }
        
        int completedCount = 0;
        
        // Process the queue
        while (!queue.isEmpty()) {
            int current = queue.poll();
            completedCount++;
            
            for (int nextCourse : adj.get(current)) {
                indegree[nextCourse]--;
                
                // If all prerequisites are met, add to queue
                if (indegree[nextCourse] == 0) {
                    queue.offer(nextCourse);
                }
            }
        }
        
        // If we processed all courses, it's possible
        return completedCount == n;
    }
}