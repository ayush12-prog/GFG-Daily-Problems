class Solution {
    public int maxSum(int arr[]) {
        int n = arr.length;
        long sum = 0;
        long currVal = 0;
        
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            currVal += (long) i * arr[i];
        }
        
        long maxVal = currVal;
        
        for (int i = 0; i < n - 1; i++) {
            currVal = currVal - sum + (long) n * arr[i];
            if (currVal > maxVal) {
                maxVal = currVal;
            }
        }
        
        return (int) maxVal;
    }
}