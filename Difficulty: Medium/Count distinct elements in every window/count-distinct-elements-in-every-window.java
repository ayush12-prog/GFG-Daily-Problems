class Solution {
    ArrayList<Integer> countDistinct(int[] arr, int k) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        int[] freq = new int[100001];
        int distinct = 0;

        for (int i = 0; i < k; i++) {
            if (freq[arr[i]] == 0) distinct++;
            freq[arr[i]]++;
        }

        res.add(distinct);

        for (int i = k; i < n; i++) {
            int out = arr[i - k];
            freq[out]--;
            if (freq[out] == 0) distinct--;

            int in = arr[i];
            if (freq[in] == 0) distinct++;
            freq[in]++;

            res.add(distinct);
        }

        return res;
    }
}