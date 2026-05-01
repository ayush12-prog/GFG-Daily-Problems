class Solution {
    public ArrayList<Integer> kthLargest(int[] arr, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Min-Heap to store the top K largest elements
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            
            // If heap size exceeds K, remove the smallest element
            if (minHeap.size() > k) {
                minHeap.poll();
            }
            
            // If we haven't seen K elements yet, the Kth largest doesn't exist
            if (minHeap.size() < k) {
                result.add(-1);
            } else {
                // The root of the Min-Heap is the Kth largest element
                result.add(minHeap.peek());
            }
        }
        
        return result;
    }
}