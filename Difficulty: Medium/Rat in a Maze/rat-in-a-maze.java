class Solution {
    public ArrayList<String> ratInMaze(int[][] maze) {
        int n = maze.length;
        ArrayList<String> result = new ArrayList<>();
        if (n == 0 || maze[0][0] == 0) {
            return result;
        }

        boolean[][] visited = new boolean[n][n];
        solve(0, 0, maze, n, result, "", visited);
        return result;
    }

    private void solve(int r, int c, int[][] maze, int n, ArrayList<String> result, String currentPath, boolean[][] visited) {
        if (r == n - 1 && c == n - 1) {
            result.add(currentPath);
            return;
        }

        visited[r][c] = true;

        if (isValid(r + 1, c, n, maze, visited)) {
            solve(r + 1, c, maze, n, result, currentPath + "D", visited);
        }
        if (isValid(r, c - 1, n, maze, visited)) {
            solve(r, c - 1, maze, n, result, currentPath + "L", visited);
        }
        if (isValid(r, c + 1, n, maze, visited)) {
            solve(r, c + 1, maze, n, result, currentPath + "R", visited);
        }
        if (isValid(r - 1, c, n, maze, visited)) {
            solve(r - 1, c, maze, n, result, currentPath + "U", visited);
        }

        visited[r][c] = false;
    }

    private boolean isValid(int r, int c, int n, int[][] maze, boolean[][] visited) {
        return r >= 0 && r < n && c >= 0 && c < n && maze[r][c] == 1 && !visited[r][c];
    }
}

