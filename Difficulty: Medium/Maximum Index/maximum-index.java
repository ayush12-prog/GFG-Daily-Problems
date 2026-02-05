class Solution {

    int maxIndexDiff(int arr[]) {
        // code here
        int n = arr.length;
        
        int[] LMin = new int[n];
        int[] RMax = new int[n];

        // Fill LMin[]
        LMin[0] = arr[0];
        for (int i = 1; i < n; i++) {
            LMin[i] = Math.min(arr[i], LMin[i - 1]);
        }

        // Fill RMax[]
        RMax[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            RMax[j] = Math.max(arr[j], RMax[j + 1]);
        }

        // Traverse both arrays
        int i = 0, j = 0, maxDiff = -1;
        while (i < n && j < n) {
            if (LMin[i] <= RMax[j]) {
                maxDiff = Math.max(maxDiff, j - i);
                j++;
            } else {
                i++;
            }
        }

        return maxDiff;
    }
}

