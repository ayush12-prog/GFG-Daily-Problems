class Solution {
    public static void rotateDeque(Deque<Integer> dq, int type, int k) {
        if (dq == null || dq.size() <= 1) {
            return;
        }

        int size = dq.size();
        k = k % size;
        
        if (k == 0) {
            return;
        }

        if (type == 1) {
            for (int i = 0; i < k; i++) {
                Integer last = dq.removeLast();
                dq.addFirst(last);
            }
        } else if (type == 2) {
            for (int i = 0; i < k; i++) {
                Integer first = dq.removeFirst();
                dq.addLast(first);
            }
        }
    }
}


