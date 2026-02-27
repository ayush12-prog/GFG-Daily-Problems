class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        if (n == 0) return 0;
        int m = mat[0].length;
        
        int[][] prefix = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                prefix[i][j] = mat[i - 1][j - 1] 
                             + prefix[i - 1][j] 
                             + prefix[i][j - 1] 
                             - prefix[i - 1][j - 1];
            }
        }
        
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int maxSize = Math.min(n - i, m - j);
                
                for (int k = 1; k <= maxSize; k++) {
                    int r1 = i;
                    int c1 = j;
                    int r2 = i + k - 1;
                    int c2 = j + k - 1;
                    
                    int sum = prefix[r2 + 1][c2 + 1] 
                            - prefix[r1][c2 + 1] 
                            - prefix[r2 + 1][c1] 
                            + prefix[r1][c1];
                            
                    if (sum == x) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}