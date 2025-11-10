class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        int hold = -arr[0], sold = 0, rest = 0;
        for (int i = 1; i < n; i++) {
            int prevSold = sold;
            sold = hold + arr[i];
            hold = Math.max(hold, rest - arr[i]);
            rest = Math.max(rest, prevSold);
        }
        return Math.max(sold, rest);
    }
}
