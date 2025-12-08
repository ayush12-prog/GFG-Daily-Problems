class Solution {
    public String matrixChainOrder(int[] arr) {
        int n = arr.length - 1;
        int[][] dp = new int[n][n];
        int[][] split = new int[n][n];

        for (int g = 1; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + arr[i] * arr[k + 1] * arr[j + 1];
                    if (cost < dp[i][j]) {
                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }
        return build(0, n - 1, split);
    }

    private String build(int i, int j, int[][] split) {
        if (i == j) return String.valueOf((char)('A' + i));
        int k = split[i][j];
        return "(" + build(i, k, split) + build(k + 1, j, split) + ")";
    }
}
