class Solution {
    public int subarrayXor(int[] arr) {
        int n = arr.length;
        int result = 0;

        for (int i = 0; i < n; i++) {
            long left = i + 1L;
            long right = n - i;

            if ((left % 2 == 1) && (right % 2 == 1)) {
                result ^= arr[i];
            }
        }
        return result;
    }
}
