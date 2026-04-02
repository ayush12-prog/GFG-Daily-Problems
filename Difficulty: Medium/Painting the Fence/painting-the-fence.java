class Solution {
    public int countWays(int n, int k) {
        if (n == 1) {
            return k;
        }
        if (n == 2) {
            return k * k;
        }
        
        long same = k;
        long diff = (long) k * (k - 1);
        
        for (int i = 3; i <= n; i++) {
            long prevSame = same;
            same = diff;
            diff = (prevSame + diff) * (k - 1);
        }
        
        return (int) (same + diff);
    }
}