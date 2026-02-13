class Solution {
    public int getCount(int n, int d) {
        int low = 1;
        int high = n;
        int ans = n + 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            
            if (mid - sumOfDigits(mid) >= d) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return n - ans + 1;
    }

    private int sumOfDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}