class Solution {
    public int josephus(int n, int k) {
        int survivor = 0; // Base case for n = 1 (0-indexed)
        
        // Iteratively calculate the survivor position for i from 2 to n
        for (int i = 2; i <= n; i++) {
            survivor = (survivor + k) % i;
        }
        
        // Convert 0-based index to 1-based index
        return survivor + 1;
    }
}