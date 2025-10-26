class Solution {
    
    public static int minCost(int[] arr) {
        
        PriorityQueue<Long> minHeap = new PriorityQueue<>();

        for (int ropeLength : arr) {
            minHeap.add((long) ropeLength);
        }

        long totalCost = 0;

        while (minHeap.size() > 1) {
            long rope1 = minHeap.poll();
            long rope2 = minHeap.poll();
            
            long newRope = rope1 + rope2;
            
            totalCost += newRope;
            
            minHeap.add(newRope);
        }
        
        return (int) totalCost;
    }
}