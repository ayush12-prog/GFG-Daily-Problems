class Solution {
    public int minTime(int[] rank, int n) {
        long low = 0;
        long high = 100000000L;
        long ans = high;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (check(mid, n, rank)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return (int) ans;
    }

    private boolean check(long time, int n, int[] rank) {
        long count = 0;
        for (int r : rank) {
            count += (long) ((Math.sqrt(1 + 8.0 * time / r) - 1) / 2);
            if (count >= n) return true;
        }
        return count >= n;
    }
}