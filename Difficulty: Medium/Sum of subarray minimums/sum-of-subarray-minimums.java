class Solution {
    public int sumSubMins(int[] arr) {
        int n = arr.length;
        int[] prev = new int[n];
        int[] next = new int[n];
        int[] stack = new int[n];
        int top = -1;
        
        for (int i = 0; i < n; i++) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }
            prev[i] = (top == -1) ? -1 : stack[top];
            stack[++top] = i;
        }
        
        top = -1;
        
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] > arr[i]) {
                top--;
            }
            next[i] = (top == -1) ? n : stack[top];
            stack[++top] = i;
        }
        
        long sum = 0;
        for (int i = 0; i < n; i++) {
            long left = i - prev[i];
            long right = next[i] - i;
            sum += (left * right * arr[i]);
        }
        
        return (int) sum;
    }
}