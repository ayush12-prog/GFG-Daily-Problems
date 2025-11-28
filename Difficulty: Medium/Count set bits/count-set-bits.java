class Solution {
    public static int countSetBits(int n) {
        int total = 0;
        int i = 0;
        
        while ((1 << i) <= n) {
            int blockSize = 1 << (i + 1);
            int fullBlocks = (n + 1) / blockSize;
            int fullContribution = fullBlocks * (1 << i);
            
            int remaining = (n + 1) % blockSize;
            int remainingContribution = Math.max(0, remaining - (1 << i));
            
            total += fullContribution + remainingContribution;
            i++;
        }
        return total;
    }
}
