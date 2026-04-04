class Solution {
    public ArrayList<String> graycode(int n) {
        ArrayList<String> result = new ArrayList<>();
        
        // Base case for n = 1
        result.add("0");
        result.add("1");
        
        // Build the sequence up to n bits
        for (int i = 2; i <= n; i++) {
            int currentSize = result.size();
            
            // Step 1: Add the reversed elements with a '1' prefix
            for (int j = currentSize - 1; j >= 0; j--) {
                result.add("1" + result.get(j));
            }
            
            // Step 2: Add a '0' prefix to the original elements
            for (int j = 0; j < currentSize; j++) {
                result.set(j, "0" + result.get(j));
            }
        }
        
        return result;
    }
}