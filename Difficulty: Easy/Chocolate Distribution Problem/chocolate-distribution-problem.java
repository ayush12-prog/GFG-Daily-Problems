// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        int n = arr.size();
        
        // Base cases
        if (m == 0 || n == 0) {
            return 0;
        }
        
        // Sort the ArrayList to bring closest values together
        Collections.sort(arr);
        
        int minDiff = Integer.MAX_VALUE;
        
        // Slide a window of size m across the sorted ArrayList
        for (int i = 0; i + m - 1 < n; i++) {
            // Difference between max and min in the current window
            int diff = arr.get(i + m - 1) - arr.get(i);
            
            // Update the minimum difference found so far
            if (diff < minDiff) {
                minDiff = diff;
            }
        }
        
        return minDiff;
    }
}