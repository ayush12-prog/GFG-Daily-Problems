class Solution {
    public ArrayList<Integer> countBSTs(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>();

        int[] catalan = computeCatalan(n);

        for (int i = 0; i < n; i++) {
            int root = arr[i];
            int left = 0, right = 0;

            for (int val : arr) {
                if (val < root) left++;
                else if (val > root) right++;
            }

            int count = catalan[left] * catalan[right];
            result.add(count);
        }

        return result;
    }

    private int[] computeCatalan(int n) {
        int[] catalan = new int[n + 1];
        catalan[0] = 1;

        for (int i = 1; i <= n; i++) {
            catalan[i] = 0;
            for (int j = 0; j < i; j++) {
                catalan[i] += catalan[j] * catalan[i - j - 1];
            }
        }

        return catalan;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] arr1 = {2, 1, 3};
        System.out.println(sol.countBSTs(arr1));

        int[] arr2 = {2, 1};
        System.out.println(sol.countBSTs(arr2));
    }
}