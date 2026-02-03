class Solution {
    public int maxProfit(int[] arr, int k) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int cash = 0;
        int hold = -arr[0];

        for (int i = 1; i < arr.length; i++) {
            
            int newCash = Math.max(cash, hold + arr[i] - k);
            
            
            int newHold = Math.max(hold, cash - arr[i]);
            
            cash = newCash;
            hold = newHold;
        }

        return cash;
    }
}