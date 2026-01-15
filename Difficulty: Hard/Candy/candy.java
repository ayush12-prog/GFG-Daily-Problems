class Solution {
    public int minCandy(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int[] candies = new int[n];
        // Give everyone 1 candy initially
        Arrays.fill(candies, 1);
        
        // Left to Right pass
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        // Right to Left pass
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
        }
        
        int totalCandies = 0;
        for (int candy : candies) {
            totalCandies += candy;
        }
        
        return totalCandies;
    }
}