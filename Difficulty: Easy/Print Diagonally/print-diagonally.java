class Solution {
    public ArrayList<Integer> diagView(int[][] matrix) {
        int n = matrix.length;
        ArrayList<Integer> result = new ArrayList<>();
        
        for (int c = 0; c < n; c++) {
            int i = 0;
            int j = c;
            while (i < n && j >= 0) {
                result.add(matrix[i][j]);
                i++;
                j--;
            }
        }
        
        for (int r = 1; r < n; r++) {
            int i = r;
            int j = n - 1;
            while (i < n && j >= 0) {
                result.add(matrix[i][j]);
                i++;
                j--;
            }
        }
        
        return result;
    }
}