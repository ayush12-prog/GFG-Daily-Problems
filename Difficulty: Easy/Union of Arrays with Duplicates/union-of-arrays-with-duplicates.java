class Solution {
    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // Since the maximum element value is 10^5, a boolean array is highly efficient
        boolean[] present = new boolean[100001];
        
        // Mark elements from the first array
        for (int num : a) {
            present[num] = true;
        }
        
        // Mark elements from the second array
        for (int num : b) {
            present[num] = true;
        }
        
        // Collect all distinct elements
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i <= 100000; i++) {
            if (present[i]) {
                result.add(i);
            }
        }
        
        return result;
    }
}