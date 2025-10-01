class Solution {
    public ArrayList<ArrayList<Integer>> uniquePerms(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        boolean[] used = new boolean[arr.length];
        generatePermutations(result, new ArrayList<>(), arr, used);
        return result;
    }

    private void generatePermutations(
        ArrayList<ArrayList<Integer>> result,
        ArrayList<Integer> currentPermutation,
        int[] arr,
        boolean[] used
    ) {
        if (currentPermutation.size() == arr.length) {
            result.add(new ArrayList<>(currentPermutation));
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i]) {
                continue;
            }
            
            if (i > 0 && arr[i] == arr[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            currentPermutation.add(arr[i]);

            generatePermutations(result, currentPermutation, arr, used);

            currentPermutation.remove(currentPermutation.size() - 1);
            used[i] = false;
        }
    }
}

