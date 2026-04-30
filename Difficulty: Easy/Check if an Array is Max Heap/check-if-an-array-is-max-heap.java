class Solution {
    public boolean isMaxHeap(int[] arr) {
        int n = arr.length;
        
        // We only need to check internal nodes, which go up to index (n / 2) - 1.
        for (int i = 0; i < n / 2; i++) {
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            
            // If the left child exists and is strictly greater than the parent
            if (left < n && arr[left] > arr[i]) {
                return false;
            }
            
            // If the right child exists and is strictly greater than the parent
            if (right < n && arr[right] > arr[i]) {
                return false;
            }
        }
        
        return true;
    }
}