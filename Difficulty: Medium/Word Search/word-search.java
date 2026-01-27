class Solution {
    public boolean isWordExist(char[][] mat, String word) {
        int n = mat.length;
        int m = mat[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[n][m];
                    if (dfs(mat, word, i, j, 0, visited)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean dfs(char[][] mat, String word, int i, int j, int index, boolean[][] visited) {
        if (i < 0 || i >= mat.length || j < 0 || j >= mat[0].length || 
            visited[i][j] || mat[i][j] != word.charAt(index)) {
            return false;
        }
        
        if (index + 1 == word.length()) {
             return true;
        }

        visited[i][j] = true;
        
        if (dfs(mat, word, i + 1, j, index + 1, visited) ||
            dfs(mat, word, i - 1, j, index + 1, visited) ||
            dfs(mat, word, i, j + 1, index + 1, visited) ||
            dfs(mat, word, i, j - 1, index + 1, visited)) {
            return true;
        }
        
        visited[i][j] = false;
        
        return false;
    }
}