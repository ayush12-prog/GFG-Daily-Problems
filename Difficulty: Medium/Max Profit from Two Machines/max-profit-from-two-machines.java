class Solution {
    public int maxProfit(int x, int y, int[] a, int[] b) {
        int n = a.length;
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }
        
        Arrays.sort(indices, (i, j) -> Integer.compare(Math.abs(a[j] - b[j]), Math.abs(a[i] - b[i])));
        
        int profit = 0;
        
        for (int i : indices) {
            if (a[i] > b[i]) {
                if (x > 0) {
                    profit += a[i];
                    x--;
                } else {
                    profit += b[i];
                    y--;
                }
            } else if (b[i] > a[i]) {
                if (y > 0) {
                    profit += b[i];
                    y--;
                } else {
                    profit += a[i];
                    x--;
                }
            } else {
                if (x > y) {
                    profit += a[i];
                    x--;
                } else {
                    profit += b[i];
                    y--;
                }
            }
        }
        
        return profit;
    }
}