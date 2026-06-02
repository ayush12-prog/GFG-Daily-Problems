class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // Sort the array in ascending order
        Arrays.sort(arr);
        
        int maxSum = 0;
        
        // Start from the largest elements at the end of the array
        for (int i = arr.length - 1; i > 0; ) {
            // Check if the difference between the current element and the next largest is less than K
            if (arr[i] - arr[i - 1] < k) {
                // If it is, they form a valid pair. Add them to the sum.
                maxSum += arr[i] + arr[i - 1];
                
                // Skip the paired element
                i -= 2;
            } else {
                // If they can't be paired, the current largest element can't be paired 
                // with anything smaller either. Move to the next element.
                i--;
            }
        }
        
        return maxSum;
    }
}