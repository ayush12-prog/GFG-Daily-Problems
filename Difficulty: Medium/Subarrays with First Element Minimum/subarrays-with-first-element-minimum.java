class Solution {
    public int countSubarrays(int[] arr) {
        int n = arr.length;
        int[] stack = new int[n];
        int top = -1;
        int total = 0;
        
        for (int i = n - 1; i >= 0; i--) {
            while (top >= 0 && arr[stack[top]] >= arr[i]) {
                top--;
            }
            int nse = (top == -1) ? n : stack[top];
            total += (nse - i);
            stack[++top] = i;
        }
        
        return total;
    }
}