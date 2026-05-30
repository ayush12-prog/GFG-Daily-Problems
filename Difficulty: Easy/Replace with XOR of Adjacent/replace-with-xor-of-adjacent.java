class Solution {
    public void replaceElements(int[] arr) {
        int n = arr.length;
        if (n <= 1) {
            return;
        }
        
        // Store the original first element
        int prev = arr[0];
        
        // Update the first element
        arr[0] = arr[0] ^ arr[1];
        
        // Update the intermediate elements
        for (int i = 1; i < n - 1; i++) {
            int curr = arr[i]; // Store original arr[i] to use it as prev for the next element
            arr[i] = prev ^ arr[i + 1];
            prev = curr;
        }
        
        // Update the last element
        arr[n - 1] = prev ^ arr[n - 1];
    }
}