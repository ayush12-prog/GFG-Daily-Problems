class Solution {
    public int minMen(int[] arr) {
        int n = arr.length;
        int[] maxRange = new int[n];
        Arrays.fill(maxRange, -1);
        
        for (int i = 0; i < n; i++) {
            if (arr[i] != -1) {
                int left = Math.max(0, i - arr[i]);
                int right = Math.min(n - 1, i + arr[i]);
                maxRange[left] = Math.max(maxRange[left], right);
            }
        }
        
        int people = 0;
        int currentCovered = -1;
        int idx = 0;
        
        while (currentCovered < n - 1) {
            int currentMax = currentCovered;
            int limit = Math.min(n - 1, currentCovered + 1);
            
            while (idx <= limit) {
                if (maxRange[idx] > currentMax) {
                    currentMax = maxRange[idx];
                }
                idx++;
            }
            
            if (currentMax <= currentCovered) {
                return -1;
            }
            
            people++;
            currentCovered = currentMax;
        }
        
        return people;
    }
}