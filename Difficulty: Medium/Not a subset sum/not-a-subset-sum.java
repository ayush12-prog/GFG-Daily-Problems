class Solution {
    public int findSmallest(int[] arr) {
        Arrays.sort(arr);
        int res = 1;
        
        for (int num : arr) {
            if (num > res) {
                break;
            }
            res += num;
        }
        
        return res;
    }
}