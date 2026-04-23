class Solution {
    public boolean canSplit(int[] arr) {
        long totalSum = 0;
        
        // Calculate the total sum of the array
        for (int num : arr) {
            totalSum += num;
        }
        
        // If the total sum is odd, it cannot be split into two equal integer halves
        if (totalSum % 2 != 0) {
            return false;
        }
        
        long currentSum = 0;
        long targetSum = totalSum / 2;
        
        // Iterate through the array to find the split point.
        // We stop at arr.length - 1 to ensure the right subarray isn't empty.
        for (int i = 0; i < arr.length - 1; i++) {
            currentSum += arr[i];
            
            if (currentSum == targetSum) {
                return true;
            }
        }
        
        return false;
    }
}