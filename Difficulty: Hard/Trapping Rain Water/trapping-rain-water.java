class Solution {
    public int maxWater(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        int res = 0;
        int maxLeft = 0;
        int maxRight = 0;
        
        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxLeft) {
                    maxLeft = arr[left];
                } else {
                    res += maxLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= maxRight) {
                    maxRight = arr[right];
                } else {
                    res += maxRight - arr[right];
                }
                right--;
            }
        }
        return res;
    }
}