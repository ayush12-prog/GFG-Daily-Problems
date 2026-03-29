class Solution {
    public int countPartitions(int[] arr, int diff) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        // Edge cases where partitioning is impossible
        if (totalSum - diff < 0 || (totalSum + diff) % 2 != 0) {
            return 0;
        }
        
        // The target sum we need to find subsets for
        int target = (totalSum + diff) / 2;
        
        // dp[i] will store the number of subsets with sum exactly equal to 'i'
        int[] dp = new int[target + 1];
        
        // There is exactly 1 way to make a sum of 0: pick the empty subset
        dp[0] = 1;
        
        // Process each number in the array
        for (int num : arr) {
            // Traverse backwards to avoid using the same element multiple times
            for (int j = target; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        
        return dp[target];
    }
}