class Solution {
    public ArrayList<Integer> findTwoElement(int[] arr) {
        int n = arr.length;
        int dup = -1, miss = -1;

        for (int i = 0; i < n; i++) {
            int idx = Math.abs(arr[i]) - 1;
            if (arr[idx] < 0) dup = Math.abs(arr[i]);
            else arr[idx] = -arr[idx];
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                miss = i + 1;
                break;
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        res.add(dup);
        res.add(miss);
        return res;
    }
}
