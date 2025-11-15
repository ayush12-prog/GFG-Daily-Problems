class Solution {
    public int minCutCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] a = new int[m + 2];
        a[0] = 0;
        for (int i = 0; i < m; i++) a[i + 1] = cuts[i];
        a[m + 1] = n;

        int K = m + 2;
        int[][] dp = new int[K][K];

        for (int len = 2; len < K; len++) {
            for (int i = 0; i + len < K; i++) {
                int j = i + len;
                int best = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + (a[j] - a[i]);
                    if (cost < best) best = cost;
                }
                dp[i][j] = (best == Integer.MAX_VALUE) ? 0 : best;
            }
        }

        return dp[0][K - 1];
    }
}