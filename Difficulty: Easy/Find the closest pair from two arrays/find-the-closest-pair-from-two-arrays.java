class Solution {
    public ArrayList<Integer> findClosestPair(int[] arr1, int[] arr2, int x) {
        int n = arr1.length;
        int m = arr2.length;
        
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        
        int i = 0;
        int j = m - 1;
        int minDiff = Integer.MAX_VALUE;
        
        while (i < n && j >= 0) {
            int sum = arr1[i] + arr2[j];
            int currentDiff = Math.abs(sum - x);
            
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                result.set(0, arr1[i]);
                result.set(1, arr2[j]);
            }
            
            if (sum > x) {
                j--;
            } else if (sum < x) {
                i++;
            } else {
                break; 
            }
        }
        
        return result;
    }
}