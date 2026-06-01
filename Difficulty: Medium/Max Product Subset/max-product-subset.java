class Solution {
    public int findMaxProduct(int[] arr) {
        int n = arr.length;
        
        // Base case: if there's only one element, return it.
        if (n == 1) {
            return arr[0];
        }
        
        long MOD = 1000000007;
        int countZero = 0;
        int countNeg = 0;
        int maxNeg = Integer.MIN_VALUE;
        
        // Traverse the array to count zeros, negative numbers, 
        // and find the maximum negative number.
        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                countZero++;
            } else if (arr[i] < 0) {
                countNeg++;
                maxNeg = Math.max(maxNeg, arr[i]);
            }
        }
        
        // If all elements are zero, the maximum product is 0.
        if (countZero == n) {
            return 0;
        }
        
        // If there's exactly one negative number and all other elements are zero,
        // the maximum product is 0 (by choosing the zero).
        if (countNeg == 1 && countZero == n - 1) {
            return 0;
        }
        
        long prod = 1;
        boolean maxNegSkipped = false;
        
        // Calculate the product
        for (int i = 0; i < n; i++) {
            // Skip zeros
            if (arr[i] == 0) {
                continue;
            }
            
            // If the count of negative numbers is odd, skip the maximum negative number once
            if (countNeg % 2 != 0 && arr[i] == maxNeg && !maxNegSkipped) {
                maxNegSkipped = true;
                continue;
            }
            
            // Multiply absolute values to avoid negative modulo issues, 
            // since the total number of negative factors included will be even.
            prod = (prod * Math.abs((long) arr[i])) % MOD;
        }
        
        return (int) prod;
    }
}