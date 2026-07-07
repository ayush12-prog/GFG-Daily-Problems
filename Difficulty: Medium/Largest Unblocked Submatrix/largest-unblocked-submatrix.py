class Solution:
    def largestArea(self, n, m, k=None, arr=None):
      
        if arr is None:
            arr = k
            k = len(arr) if arr else 0
            
        if not arr or k == 0:
            return n * m
            
        rows = [0] + [cell[0] for cell in arr] + [n + 1]
        cols = [0] + [cell[1] for cell in arr] + [m + 1]
        
        rows.sort()
        cols.sort()
        
        max_row_gap = 0
        for i in range(1, len(rows)):
            max_row_gap = max(max_row_gap, rows[i] - rows[i-1] - 1)
            
        max_col_gap = 0
        for i in range(1, len(cols)):
            max_col_gap = max(max_col_gap, cols[i] - cols[i-1] - 1)
            
        return max_row_gap * max_col_gap