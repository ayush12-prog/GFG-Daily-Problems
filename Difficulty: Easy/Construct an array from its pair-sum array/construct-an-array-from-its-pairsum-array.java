class Solution {
    public ArrayList<Integer> constructArr(int[] arr) {
        int m = arr.length;
        int n = (int)((1 + Math.sqrt(1 + 8L * m)) / 2);

        int[][] idx = new int[n][n];
        int p = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++)
                idx[i][j] = p++;

        int[] res = new int[n];

        if (n == 2) {
            int sum = arr[0];
            res[0] = sum / 2;
            res[1] = sum - res[0];
        } else {
            int a0 = (arr[idx[0][1]] + arr[idx[0][2]] - arr[idx[1][2]]) / 2;
            res[0] = a0;
            for (int j = 1; j < n; j++)
                res[j] = arr[idx[0][j]] - a0;
        }

        p = 0;
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j < n; j++) {
                if (res[i] + res[j] != arr[p++])
                    return new ArrayList<>();
            }

        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : res) ans.add(x);
        return ans;
    }
}
