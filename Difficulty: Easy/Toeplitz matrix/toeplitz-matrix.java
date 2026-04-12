class Solution {
    boolean isToeplitz(int mat[][]) {
        int m = mat.length;
        if (m == 0) return true;
        int n = mat[0].length;
        
        // Start from the second row and second column
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                // Check if current element matches its top-left neighbor
                if (mat[i][j] != mat[i - 1][j - 1]) {
                    return false;
                }
            }
        }
        
        // If no mismatches were found, it is a Toeplitz matrix
        return true;
    }
}