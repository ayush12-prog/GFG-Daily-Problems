class Solution {
    public ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int left = 0, sum = 0;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target && left < right) {
                sum -= arr[left];
                left++;
            }

            if (sum == target) {
                res.add(left + 1);
                res.add(right + 1);
                return res;
            }
        }

        res.add(-1);
        return res;
    }
}