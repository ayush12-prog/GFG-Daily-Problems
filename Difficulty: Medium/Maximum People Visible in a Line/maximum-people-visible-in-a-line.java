class Solution {
    public int maxPeople(int[] arr) {
        int n = arr.length;
        if (n == 0) return 0;
        
        int[] leftBound = new int[n];
        int[] rightBound = new int[n];
        
        // Stack to find Previous Greater or Equal Element
        // We store indices in the stack
        Deque<Integer> stack = new ArrayDeque<>();
        
        // Left Pass
        for (int i = 0; i < n; i++) {
            // Pop elements that are strictly smaller than current
            // We stop when we find an element >= arr[i] or stack becomes empty
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                leftBound[i] = -1; // Can see everything to the left
            } else {
                leftBound[i] = stack.peek(); // Blocked by this index
            }
            stack.push(i);
        }
        
        stack.clear();
        
        // Right Pass
        for (int i = n - 1; i >= 0; i--) {
            // Pop elements that are strictly smaller than current
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            
            if (stack.isEmpty()) {
                rightBound[i] = n; // Can see everything to the right
            } else {
                rightBound[i] = stack.peek(); // Blocked by this index
            }
            stack.push(i);
        }
        
        int maxSeen = 0;
        for (int i = 0; i < n; i++) {
            // Visible count = (left count) + (right count) + (self)
            // Left count = i - leftBound[i] - 1
            // Right count = rightBound[i] - i - 1
            // Total = (i - leftBound[i] - 1) + (rightBound[i] - i - 1) + 1
            // Total = rightBound[i] - leftBound[i] - 1
            int visible = rightBound[i] - leftBound[i] - 1;
            if (visible > maxSeen) {
                maxSeen = visible;
            }
        }
        
        return maxSeen;
    }
}