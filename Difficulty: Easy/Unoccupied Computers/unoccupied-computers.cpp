class Solution {
  public:
    int solve(int n, string s) {
        int state[26] = {0};

        int available = n;

        int rejected = 0;

        for (char ch : s) {
            int id = ch - 'A';

            if (state[id] == 0) {
                if (available > 0) {
                    available--;
                    state[id] = 1;
                } else {
                    rejected++;

                    state[id] = 2;
                }
            } else {
                if (state[id] == 1) {
                    available++;
                }
            }
        }

        return rejected;
    }
};