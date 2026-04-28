class Solution {
    public int longestSubstr(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int n = s.length();
        int left = 0;
        int maxFreq = 0;
        int maxLength = 0;
        
        // Frequency array to store counts of each uppercase English letter (A-Z)
        int[] freq = new int[26];

        for (int right = 0; right < n; right++) {
            // Increment frequency of the character entering the window from the right
            int charIdx = s.charAt(right) - 'A';
            freq[charIdx]++;

            // Maintain the frequency of the most frequent character seen in the current window
            maxFreq = Math.max(maxFreq, freq[charIdx]);

            /* 
               Condition: (Window Size - Max Frequency) = Number of characters to change.
               If this value exceeds k, the current window is invalid.
               We move the left pointer to shrink the window.
            */
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
                
                /* 
                   Optimization Note: We don't need to re-calculate maxFreq here because 
                   we are only interested in windows that are larger than our current maxLength. 
                   A smaller maxFreq wouldn't help us find a new maximum length.
                */
            }

            // Calculate the maximum length found so far
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}