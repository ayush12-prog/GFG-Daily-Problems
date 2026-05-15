class Solution {
    public int optimalKeys(int n) {
        if (n <= 6) {
            return n;
        }
        
        int[] dp = new int[n + 1];
        
        for (int i = 1; i <= 6; i++) {
            dp[i] = i;
        }
        
        for (int i = 7; i <= n; i++) {
            dp[i] = i; 
            for (int j = i - 3; j >= 1; j--) {
                int current = (i - j - 1) * dp[j];
                if (current > dp[i]) {
                    dp[i] = current;
                }
            }
        }
        
        return dp[n];
    }
}