class Solution {
    public int kBitFlips(int[] arr, int k) {
        int n = arr.length;
        int[] isFlipped = new int[n];
        int flipCount = 0;
        int ans = 0;
        
        for (int i = 0; i < n; i++) {
            if (i >= k) {
                flipCount -= isFlipped[i - k];
            }
            
            if (arr[i] == flipCount % 2) {
                if (i + k > n) {
                    return -1;
                }
                ans++;
                flipCount++;
                isFlipped[i] = 1;
            }
        }
        
        return ans;
    }
}