class Solution {
    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();

        int start = 0;
        int bestStart = 0;
        int bestLength = 0;

        for (int end = 0; end < n; end++) {
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[end]) {
                minDeque.pollLast();
            }
            minDeque.offerLast(end);

            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[end]) {
                maxDeque.pollLast();
            }
            maxDeque.offerLast(end);

            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > x) {
                start++;
                if (minDeque.peekFirst() < start) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() < start) {
                    maxDeque.pollFirst();
                }
            }
            
            if (end - start + 1 > bestLength) {
                bestLength = end - start + 1;
                bestStart = start;
            }
        }
        
        ArrayList<Integer> result = new ArrayList<>();
        if (n > 0 && bestLength == 0) {
            bestLength = 1;
        }

        for (int i = 0; i < bestLength; i++) {
            result.add(arr[bestStart + i]);
        }
        
        return result;
    }
}

