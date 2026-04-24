class Solution {
    public int visibleBuildings(int[] arr) {
        // Edge case for empty array
        if (arr == null || arr.length == 0) {
            return 0;
        }
        
        // The first building will always receive sunlight
        int count = 1;
        int maxSoFar = arr[0];
        
        // Check the rest of the buildings
        for (int i = 1; i < arr.length; i++) {
            // If the current building is taller than or equal to the tallest seen so far
            if (arr[i] >= maxSoFar) {
                count++;
                maxSoFar = arr[i]; // Update the new tallest building blocking the sun
            }
        }
        
        return count;
    }
}