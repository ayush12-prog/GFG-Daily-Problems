class Solution {
    public int findPosition(int n) {
        // Step 1: Check if n has exactly one set bit
        // n must be strictly positive, and n & (n - 1) must be 0
        if (n <= 0 || (n & (n - 1)) != 0) {
            return -1;
        }
        
        // Step 2: Find the position of that set bit
        int pos = 1;
        while ((n & 1) == 0) {
            n >>= 1; // Right shift by 1
            pos++;
        }
        
        return pos;
    }
}