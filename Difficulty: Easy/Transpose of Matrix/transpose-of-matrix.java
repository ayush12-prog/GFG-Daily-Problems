class Solution {
    public ArrayList<ArrayList<Integer>> transpose(int[][] matrix) {
        int n = matrix.length;

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int j = 0; j < n; j++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                row.add(matrix[i][j]);
            }
            res.add(row);
        }

        return res;
    }
}
