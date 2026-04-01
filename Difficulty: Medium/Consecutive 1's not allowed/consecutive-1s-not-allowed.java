class Solution {
    public int countStrings(int n) {
        int zeroEnd = 1;
        int oneEnd = 1;
        
        for (int i = 2; i <= n; i++) {
            int nextZeroEnd = zeroEnd + oneEnd;
            int nextOneEnd = zeroEnd;
            
            zeroEnd = nextZeroEnd;
            oneEnd = nextOneEnd;
        }
        
        return zeroEnd + oneEnd;
    }
}