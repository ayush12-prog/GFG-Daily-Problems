class Solution {
    public boolean checkElements(int start, int end, int[] arr) {
        int rangeSize = end - start + 1;
        boolean[] present = new boolean[rangeSize];
        
        for (int num : arr) {
            if (num >= start && num <= end) {
                present[num - start] = true; 
            }
        }
        
        for (int i = 0; i < rangeSize; i++) {
            if (!present[i]) {
                return false; 
            }
        }
        
        return true; 
    }
}