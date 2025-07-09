class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int[] ple = new int[n];  // Previous Less Element indices
        int[] nle = new int[n];  // Next Less Element indices
        Stack<Integer> stack = new Stack<>();

        // Find Previous Less Element (PLE)
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            ple[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Find Next Less Element (NLE)
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            nle[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Compute the result
        long result = 0;
        int mod = (int)1e9 + 7;  // Optional, if modulus is required in future

        for (int i = 0; i < n; i++) {
            long left = i - ple[i];
            long right = nle[i] - i;
            result += (long) arr[i] * left * right;
        }

        return (int) result; // Guaranteed to fit in 32-bit unsigned int
    }
}
