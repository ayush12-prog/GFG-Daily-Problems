class Solution {
    public int countSubset(int[] arr, int k) {
        int n = arr.length;
        int n1 = n / 2;
        int n2 = n - n1;
        
        Map<Long, Integer> leftSums = new HashMap<>();
        
        for (int i = 0; i < (1 << n1); i++) {
            long currentSum = 0;
            for (int j = 0; j < n1; j++) {
                if ((i & (1 << j)) != 0) {
                    currentSum += arr[j];
                }
            }
            leftSums.put(currentSum, leftSums.getOrDefault(currentSum, 0) + 1);
        }
        
        int count = 0;
        
        for (int i = 0; i < (1 << n2); i++) {
            long currentSum = 0;
            for (int j = 0; j < n2; j++) {
                if ((i & (1 << j)) != 0) {
                    currentSum += arr[n1 + j];
                }
            }
            
            long target = k - currentSum;
            if (leftSums.containsKey(target)) {
                count += leftSums.get(target);
            }
        }
        
        return count;
    }
}