class Solution {
    public int minSwaps(int[] arr) {
        int n = arr.length;

        // Count total number of 1s
        int totalOnes = 0;
        for (int val : arr) {
            if (val == 1) {
                totalOnes++;
            }
        }

        // If no 1s are present
        if (totalOnes == 0) {
            return -1;
        }

        // If all elements are 1s, no swap needed
        if (totalOnes == n) {
            return 0;
        }

        /*
          We need a window of size totalOnes.
          The best window is the one that already contains maximum 1s.
          Minimum swaps = zeros in that best window.
        */

        int currentOnes = 0;

        // First window
        for (int i = 0; i < totalOnes; i++) {
            if (arr[i] == 1) {
                currentOnes++;
            }
        }

        int maxOnesInWindow = currentOnes;

        // Sliding window
        for (int right = totalOnes; right < n; right++) {
            if (arr[right] == 1) {
                currentOnes++;
            }

            if (arr[right - totalOnes] == 1) {
                currentOnes--;
            }

            maxOnesInWindow = Math.max(maxOnesInWindow, currentOnes);
        }

        return totalOnes - maxOnesInWindow;
    }
}