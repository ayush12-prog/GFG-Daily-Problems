class Solution {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> span = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        
        for (int i = 0; i < n; i++) {
            // Pop elements that are smaller or equal to current price
            while (!st.isEmpty() && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            
            // If stack empty, current price is greatest so far
            if (st.isEmpty()) {
                span.add(i + 1);
            } else {
                // Current index - Previous Greater Element Index
                span.add(i - st.peek());
            }
            
            // Push current index to stack
            st.push(i);
        }
        return span;
    }
}