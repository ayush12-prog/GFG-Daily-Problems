class Solution {
    public ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        backtrack(arr, 0, result);
        return result;
    }

    private void backtrack(int[] arr, int index, ArrayList<ArrayList<Integer>> result) {
        if (index == arr.length) {
            ArrayList<Integer> currentPermutation = new ArrayList<>();
            for (int num : arr) {
                currentPermutation.add(num);
            }
            result.add(currentPermutation);
            return;
        }

        for (int i = index; i < arr.length; i++) {
            swap(arr, index, i);
            backtrack(arr, index + 1, result);
            swap(arr, index, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}