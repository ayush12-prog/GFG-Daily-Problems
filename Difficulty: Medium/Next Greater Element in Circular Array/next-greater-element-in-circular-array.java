class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        int n = arr.length;
        int[] result = new int[n];
        Arrays.fill(result, -1); // Initialize with -1

        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse the array twice to simulate circular behavior
        for (int i = 2 * n - 1; i >= 0; i--) {
            int idx = i % n;

            // Maintain decreasing stack
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[idx]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                result[idx] = arr[stack.peek()];
            }

            stack.push(idx);
        }

        // Convert array to ArrayList
        ArrayList<Integer> list = new ArrayList<>();
        for (int val : result) {
            list.add(val);
        }

        return list;
    }
}
