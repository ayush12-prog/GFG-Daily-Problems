class Solution {
    public int smallestSubstring(String s) {
        int idx0 = -1;
        int idx1 = -1;
        int idx2 = -1;
        int minLen = Integer.MAX_VALUE;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            // Update the last seen index for the current character
            if (c == '0') idx0 = i;
            else if (c == '1') idx1 = i;
            else if (c == '2') idx2 = i;
            
            // If all three characters have been seen at least once
            if (idx0 != -1 && idx1 != -1 && idx2 != -1) {
                // The start of the valid window is the oldest of the three indices
                int start = Math.min(idx0, Math.min(idx1, idx2));
                
                // Calculate length and update minimum
                minLen = Math.min(minLen, i - start + 1);
            }
        }
        
        // If minLen was never updated, return -1. Otherwise, return minLen.
        return minLen == Integer.MAX_VALUE ? -1 : minLen;
    }
}