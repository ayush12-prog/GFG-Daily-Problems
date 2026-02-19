class Solution {
    public ArrayList<Integer> missingRange(int[] arr, int low, int high) {
        boolean[] present = new boolean[high + 1];
        
        for (int num : arr) {
            if (num <= high && num >= 0) {
                present[num] = true;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            if (i >= 0 && !present[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}