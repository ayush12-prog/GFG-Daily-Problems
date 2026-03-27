class Solution {
    public int maxChocolate(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][][] memo = new int[n][m][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < m; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }
        
        return dfs(0, 0, m - 1, n, m, grid, memo);
    }

    private int dfs(int i, int j1, int j2, int n, int m, int[][] grid, int[][][] memo) {
        if (j1 < 0 || j1 >= m || j2 < 0 || j2 >= m) {
            return (int) -1e9;
        }

        if (i == n - 1) {
            if (j1 == j2) {
                return grid[i][j1];
            } else {
                return grid[i][j1] + grid[i][j2];
            }
        }

        if (memo[i][j1][j2] != -1) {
            return memo[i][j1][j2];
        }

        int maxChoc = (int) -1e9;
        
        for (int dj1 = -1; dj1 <= 1; dj1++) {
            for (int dj2 = -1; dj2 <= 1; dj2++) {
                int currentChoc;
                
                if (j1 == j2) {
                    currentChoc = grid[i][j1];
                } else {
                    currentChoc = grid[i][j1] + grid[i][j2];
                }
                
                currentChoc += dfs(i + 1, j1 + dj1, j2 + dj2, n, m, grid, memo);
                
                maxChoc = Math.max(maxChoc, currentChoc);
            }
        }

        return memo[i][j1][j2] = maxChoc;
    }
}