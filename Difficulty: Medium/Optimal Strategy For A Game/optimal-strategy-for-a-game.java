class Solution {
    public int maximumAmount(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++)
            dp[i][i] = arr[i];

        for (int g = 1; g < n; g++) {
            for (int i = 0, j = g; j < n; i++, j++) {
                int a = (i + 2 <= j) ? dp[i + 2][j] : 0;
                int b = (i + 1 <= j - 1) ? dp[i + 1][j - 1] : 0;
                int c = (i <= j - 2) ? dp[i][j - 2] : 0;
                int pickStart = arr[i] + Math.min(a, b);
                int pickEnd = arr[j] + Math.min(b, c);
                dp[i][j] = Math.max(pickStart, pickEnd);
            }
        }

        return dp[0][n - 1];
    }
}
