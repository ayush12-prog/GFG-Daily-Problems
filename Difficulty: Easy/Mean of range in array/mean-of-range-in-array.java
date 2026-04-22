class Solution {
    public ArrayList<Integer> findMean(int[] arr, int[][] queries) {
        int n = arr.length;
        
        // 1-based prefix sum array to avoid out-of-bounds checks for index 0
        // Using long to prevent any potential integer overflow
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            
            // O(1) subarray sum calculation
            long sum = prefix[r + 1] - prefix[l];
            int count = r - l + 1;
            
            // Integer division naturally floors the result for positive numbers
            result.add((int) (sum / count));
        }
        
        return result;
    }
}