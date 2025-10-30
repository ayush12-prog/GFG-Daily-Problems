class Solution {
    public char[][] fill(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 'O' && !vis[i][0]) dfs(i, 0, grid, vis, n, m);
            if (grid[i][m - 1] == 'O' && !vis[i][m - 1]) dfs(i, m - 1, grid, vis, n, m);
        }
        for (int j = 0; j < m; j++) {
            if (grid[0][j] == 'O' && !vis[0][j]) dfs(0, j, grid, vis, n, m);
            if (grid[n - 1][j] == 'O' && !vis[n - 1][j]) dfs(n - 1, j, grid, vis, n, m);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'O' && !vis[i][j]) grid[i][j] = 'X';
            }
        }
        return grid;
    }

    private void dfs(int i, int j, char[][] grid, boolean[][] vis, int n, int m) {
        if (i < 0 || j < 0 || i >= n || j >= m || vis[i][j] || grid[i][j] == 'X') return;
        vis[i][j] = true;
        dfs(i + 1, j, grid, vis, n, m);
        dfs(i - 1, j, grid, vis, n, m);
        dfs(i, j + 1, grid, vis, n, m);
        dfs(i, j - 1, grid, vis, n, m);
    }
}