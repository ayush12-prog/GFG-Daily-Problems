// User function Template for Java

class Solution {
    void convert(int[] arr, int n) {
        int[][] pairs = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            pairs[i][0] = arr[i];
            pairs[i][1] = i;
        }
        
        Arrays.sort(pairs, (a, b) -> Integer.compare(a[0], b[0]));
        
        for (int i = 0; i < n; i++) {
            int originalIndex = pairs[i][1];
            arr[originalIndex] = i;
        }
    }
}