class Solution {
    public int minCost(int[] keys, int[] freq) {
        int n = keys.length;
        int[][] dp = new int[n][n];
        int[][] sum = new int[n][n];

        for (int i = 0; i < n; i++) {
            sum[i][i] = freq[i];
            dp[i][i] = freq[i];
        }

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                sum[i][j] = sum[i][j - 1] + freq[j];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int r = i; r <= j; r++) {
                    int left = (r > i ? dp[i][r - 1] : 0);
                    int right = (r < j ? dp[r + 1][j] : 0);
                    dp[i][j] = Math.min(dp[i][j], left + right + sum[i][j]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
