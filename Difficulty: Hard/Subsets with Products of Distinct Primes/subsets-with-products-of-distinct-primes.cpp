class Solution {
public:
    int mod = 1e9 + 7;

    int countSubsets(vector<int> &arr) {
        vector<int> freq(31, 0);
        for (int x : arr)
            freq[x]++;

        vector<int> prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29};
        vector<int> mask(31, 0);

        for (int i = 2; i <= 30; i++) {
            int x = i;
            int m = 0;
            bool ok = true;

            for (int j = 0; j < 10; j++) {
                int p = prime[j];
                int cnt = 0;
                while (x % p == 0) {
                    cnt++;
                    x /= p;
                }
                if (cnt > 1) {
                    ok = false;
                    break;
                }
                if (cnt == 1)
                    m |= (1 << j);
            }

            if (ok)
                mask[i] = m;
        }

        vector<long long> dp(1024, 0);
        dp[0] = 1;

        for (int i = 2; i <= 30; i++) {
            if (freq[i] == 0 || mask[i] == 0)
                continue;

            vector<long long> next = dp;

            for (int m = 0; m < 1024; m++) {
                if ((m & mask[i]) == 0) {
                    next[m | mask[i]] = (next[m | mask[i]] + dp[m] * freq[i]) % mod;
                }
            }

            dp = next;
        }

        long long ans = 0;
        for (int i = 1; i < 1024; i++)
            ans = (ans + dp[i]) % mod;

        // Handle multiple 1s: every good subset can include any number of 1s
        long long ones = 1;
        for (int i = 0; i < freq[1]; i++)
            ones = (ones * 2) % mod;

        return (ans * ones) % mod;
    }
};