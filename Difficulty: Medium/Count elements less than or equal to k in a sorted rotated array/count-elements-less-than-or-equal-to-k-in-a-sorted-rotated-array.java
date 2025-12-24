class Solution {
    public int countLessEqual(int[] arr, int x) {
        int n = arr.length;
        int low = 0, high = n - 1;
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] > arr[high]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        int pivot = low;
        return count(arr, 0, pivot - 1, x) + count(arr, pivot, n - 1, x);
    }
    
    private int count(int[] arr, int low, int high, int x) {
        int ans = 0;
        int start = low;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= x) {
                ans = mid - start + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }
}