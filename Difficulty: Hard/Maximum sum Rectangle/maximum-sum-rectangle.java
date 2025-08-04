class Solution {
    public int maxRectSum(int mat[][]) {
        int n = mat.length;
        int m = mat[0].length;
        int maxSum = Integer.MIN_VALUE;

        for (int top = 0; top < n; top++) {
            int[] temp = new int[m];

            for (int bottom = top; bottom < n; bottom++) {
                for (int i = 0; i < m; i++) {
                    temp[i] += mat[bottom][i];
                }

                int currMax = kadane(temp);
                maxSum = Math.max(maxSum, currMax);
            }
        }

        return maxSum;
    }

    private int kadane(int[] arr) {
        int maxSoFar = arr[0];
        int currMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }

        return maxSoFar;
    }
};
