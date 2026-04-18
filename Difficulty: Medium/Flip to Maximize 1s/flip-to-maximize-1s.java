class Solution {
    public int maxOnes(int[] arr) {
        int totalOnes = 0;
        int maxGain = 0;
        int currentGain = 0;
        
        for (int num : arr) {
            // Count initial 1s
            if (num == 1) {
                totalOnes++;
            }
            
            // Calculate the net gain for the current element
            int val = (num == 0) ? 1 : -1;
            currentGain += val;
            
            // If current gain drops below 0, it's better to start a new subarray
            if (currentGain < 0) {
                currentGain = 0;
            }
            
            // Track the maximum gain found so far
            if (currentGain > maxGain) {
                maxGain = currentGain;
            }
        }
        
        // Final result is the original 1s plus the best possible gain from flipping
        return totalOnes + maxGain;
    }
}