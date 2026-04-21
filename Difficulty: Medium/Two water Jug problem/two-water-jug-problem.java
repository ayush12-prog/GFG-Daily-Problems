class Solution {
    public int minSteps(int m, int n, int d) {
        // If target is greater than both capacities, it's impossible
        if (d > Math.max(m, n)) {
            return -1;
        }
        
        // Target must be a multiple of the GCD of both capacities
        if (d % gcd(m, n) != 0) {
            return -1;
        }
        
        // The minimum steps will be the minimum of the two pouring strategies:
        // 1. Always fill m, pour to n
        // 2. Always fill n, pour to m
        return Math.min(pour(m, n, d), pour(n, m, d));
    }
    
    private int pour(int fromCap, int toCap, int d) {
        int fromJug = fromCap;
        int toJug = 0;
        int steps = 1;
        
        while (fromJug != d && toJug != d) {
            // Find the maximum amount we can pour
            int amountToPour = Math.min(fromJug, toCap - toJug);
            
            // Pour the water
            toJug += amountToPour;
            fromJug -= amountToPour;
            steps++;
            
            // Check if we reached the target in either jug
            if (fromJug == d || toJug == d) {
                break;
            }
            
            // If the source jug becomes empty, fill it completely
            if (fromJug == 0) {
                fromJug = fromCap;
                steps++;
            }
            
            // If the destination jug becomes full, empty it completely
            if (toJug == toCap) {
                toJug = 0;
                steps++;
            }
        }
        
        return steps;
    }
    
    private int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }
}