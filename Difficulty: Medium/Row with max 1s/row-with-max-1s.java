class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        if (n == 0) return -1;
        int m = arr[0].length;
        
        int maxRowIndex = -1;
        
        int r = 0;
        int c = m - 1;
        
        while (r < n && c >= 0) {
            if (arr[r][c] == 1) {
                maxRowIndex = r;
                c--;
            } else {
                r++;
            }
        }
        
        return maxRowIndex;
    }
}