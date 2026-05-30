import java.util.Arrays;

class Solution {
    public int validGroups(String s) {
        int n = s.length();
        // The maximum possible sum for a string of length 100 is 100 * 9 = 900
        int[][] memo = new int[n][905];
        
        // Initialize memoization table with -1
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        
        return solve(0, 0, s, memo);
    }
    
    private int solve(int idx, int prevSum, String s, int[][] memo) {
        // Base case: successfully reached the end of the string
        if (idx == s.length()) {
            return 1;
        }
        
        // Return precalculated result if it exists
        if (memo[idx][prevSum] != -1) {
            return memo[idx][prevSum];
        }
        
        int count = 0;
        int currSum = 0;
        
        // Try making a sub-group from 'idx' to 'j'
        for (int j = idx; j < s.length(); j++) {
            currSum += s.charAt(j) - '0';
            
            // If the current sub-group sum is >= previous sub-group sum, it's valid
            if (currSum >= prevSum) {
                count += solve(j + 1, currSum, s, memo);
            }
        }
        
        // Store and return the calculated result
        memo[idx][prevSum] = count;
        return count;
    }
}