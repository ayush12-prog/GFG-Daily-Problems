class Solution {
    public ArrayList<ArrayList<Integer>> kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>(
            (p1, p2) -> {
                int d1_sq = p1[0] * p1[0] + p1[1] * p1[1];
                int d2_sq = p2[0] * p2[0] + p2[1] * p2[1];
                
                return d2_sq - d1_sq; 
            }
        );

        for (int[] point : points) {
            maxHeap.offer(point);
            
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }
        
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        while (!maxHeap.isEmpty()) {
            int[] point = maxHeap.poll();
            
            ArrayList<Integer> listPoint = new ArrayList<>();
            listPoint.add(point[0]);
            listPoint.add(point[1]);
            
            result.add(listPoint);
        }
        
        return result;
    }
}
