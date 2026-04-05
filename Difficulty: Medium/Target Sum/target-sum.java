class Solution {
    public int totalWays(int[] arr, int target) {
        int totalSum = 0;
        for (int num : arr) {
            totalSum += num;
        }
        
        if (Math.abs(target) > totalSum || (totalSum + target) % 2 != 0) {
            return 0;
        }
        
        int s1 = (totalSum + target) / 2;
        int[] dp = new int[s1 + 1];
        
        dp[0] = 1;
        
        for (int num : arr) {
            for (int j = s1; j >= num; j--) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        
        return dp[s1];
    }
}