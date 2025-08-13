import java.util.*;

class Solution {
    public long minSoldiers(int[] arr, int k) {
        int n = arr.length;
        int required = (n + 1) / 2; // ceil(n/2)
        int alreadyLucky = 0;

        // freq[cost] = how many troops need exactly "cost" soldiers to become divisible by k
        int[] freq = new int[k]; // costs are in [1..k-1]; we'll skip index 0

        for (int soldiers : arr) {
            int r = soldiers % k;
            if (r == 0) {
                alreadyLucky++;
            } else {
                int cost = k - r;
                freq[cost]++;
            }
        }

        if (alreadyLucky >= required) return 0L;

        int need = required - alreadyLucky;
        long added = 0L;

        for (int cost = 1; cost < k && need > 0; cost++) {
            int take = Math.min(freq[cost], need);
            added += (long) take * cost;
            need -= take;
        }

        return added;
    }
}
