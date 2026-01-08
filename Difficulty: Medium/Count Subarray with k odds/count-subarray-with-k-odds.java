class Solution {
    public int countSubarrays(int[] arr, int k) {
        int n = arr.length;
        int[] prefixCount = new int[n + 1];
        prefixCount[0] = 1;
        int oddCount = 0;
        int result = 0;
        
        for (int num : arr) {
            if (num % 2 != 0) {
                oddCount++;
            }
            
            if (oddCount >= k) {
                result += prefixCount[oddCount - k];
            }
            
            prefixCount[oddCount]++;
        }
        
        return result;
    }
}