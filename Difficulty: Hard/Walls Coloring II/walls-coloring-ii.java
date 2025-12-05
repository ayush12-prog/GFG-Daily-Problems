class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        if (n == 0) return 0;

        int k = costs[0].length;
        if (k == 0) return -1;
        if (k == 1) return n == 1 ? costs[0][0] : -1;

        int[][] dp = new int[n][k];

        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE, idx1 = -1;
        for (int j = 0; j < k; j++) {
            dp[0][j] = costs[0][j];
            if (dp[0][j] < min1) {
                min2 = min1;
                min1 = dp[0][j];
                idx1 = j;
            } else if (dp[0][j] < min2) {
                min2 = dp[0][j];
            }
        }

        for (int i = 1; i < n; i++) {
            int newMin1 = Integer.MAX_VALUE, newMin2 = Integer.MAX_VALUE, newIdx1 = -1;
            for (int j = 0; j < k; j++) {
                if (j == idx1) dp[i][j] = costs[i][j] + min2;
                else dp[i][j] = costs[i][j] + min1;

                if (dp[i][j] < newMin1) {
                    newMin2 = newMin1;
                    newMin1 = dp[i][j];
                    newIdx1 = j;
                } else if (dp[i][j] < newMin2) {
                    newMin2 = dp[i][j];
                }
            }
            min1 = newMin1;
            min2 = newMin2;
            idx1 = newIdx1;
        }

        return min1 == Integer.MAX_VALUE ? -1 : min1;
    }
}
