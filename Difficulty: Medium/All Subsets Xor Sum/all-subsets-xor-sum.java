class Solution {
    public int subsetXORSum(int[] arr) {
        int n = arr.length;
        int or = 0;
        for (int x : arr) {
            or |= x;
        }
        return or * (1 << (n - 1));
    }
}
