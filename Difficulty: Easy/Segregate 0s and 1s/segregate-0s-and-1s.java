class Solution {
    public void segregate0and1(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            // Move left pointer forward if it's already pointing to 0
            while (left < right && arr[left] == 0) {
                left++;
            }
            
            // Move right pointer backward if it's already pointing to 1
            while (left < right && arr[right] == 1) {
                right--;
            }
            
            // If left is pointing to 1 and right is pointing to 0, swap them
            if (left < right) {
                arr[left] = 0;
                arr[right] = 1;
                left++;
                right--;
            }
        }
    }
}