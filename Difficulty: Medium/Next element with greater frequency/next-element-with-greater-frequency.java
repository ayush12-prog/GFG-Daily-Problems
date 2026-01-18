class Solution {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int num : arr) {
            freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(n, -1));
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            int currentFreq = freqMap.get(arr[i]);
            
            while (!stack.isEmpty() && freqMap.get(stack.peek()) <= currentFreq) {
                stack.pop();
            }
            
            if (!stack.isEmpty()) {
                result.set(i, stack.peek());
            }
            
            stack.push(arr[i]);
        }
        
        return result;
    }
}