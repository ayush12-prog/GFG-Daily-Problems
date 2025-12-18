import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
        ArrayList<Integer> odd = new ArrayList<>();
        ArrayList<Integer> even = new ArrayList<>();

        for (int x : arr) {
            if ((x & 1) == 1) odd.add(x);
            else even.add(x);
        }

        Collections.sort(odd, Collections.reverseOrder());
        Collections.sort(even);

        int idx = 0;
        for (int x : odd) arr[idx++] = x;
        for (int x : even) arr[idx++] = x;
    }
}
