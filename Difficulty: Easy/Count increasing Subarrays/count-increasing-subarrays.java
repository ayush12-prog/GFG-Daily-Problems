class Solution {
    public int countIncreasing(int[] arr) {
        int count = 0;
        int len = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1]) {
                len++;
                // Add the number of new valid subarrays ending at this index
                count += (len - 1);
            } else {
                // Sequence broke, reset length
                len = 1;
            }
        }
        
        return count;
    }
}