class Solution {
    private static final int[] rowMoves = {2, 1, -1, -2, -2, -1, 1, 2};
    private static final int[] colMoves = {1, 2, 2, 1, -1, -2, -2, -1};
    
    public ArrayList<ArrayList<Integer>> knightTour(int n) {
        int[][] board = new int[n][n];
        for (int[] row : board) Arrays.fill(row, -1);
        board[0][0] = 0;
        if (solve(0, 0, 1, board, n)) {
            ArrayList<ArrayList<Integer>> res = new ArrayList<>();
            for (int[] row : board) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int val : row) list.add(val);
                res.add(list);
            }
            return res;
        }
        return new ArrayList<>();
    }

    private boolean solve(int r, int c, int move, int[][] board, int n) {
        if (move == n * n) return true;
        for (int i = 0; i < 8; i++) {
            int nr = r + rowMoves[i], nc = c + colMoves[i];
            if (nr >= 0 && nr < n && nc >= 0 && nc < n && board[nr][nc] == -1) {
                board[nr][nc] = move;
                if (solve(nr, nc, move + 1, board, n)) return true;
                board[nr][nc] = -1;
            }
        }
        return false;
    }
}