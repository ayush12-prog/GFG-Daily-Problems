class Solution {
    public int maxSubarraySum(int[] arr, int k) {
        long currentSum = 0;
        // Calculate sum of the first window
        for (int i = 0; i < k; i++) {
            currentSum += arr[i];
        }
        
        long maxSum = currentSum;
        
        // Slide the window
        for (int i = k; i < arr.length; i++) {
            currentSum += arr[i] - arr[i - k];
            if (currentSum > maxSum) {
                maxSum = currentSum;
            }
        }
        
        return (int) maxSum;
    }
}