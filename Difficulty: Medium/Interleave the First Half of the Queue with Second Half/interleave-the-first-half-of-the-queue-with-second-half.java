class Solution {
    public ArrayList<Integer> rearrangeQueue(Queue<Integer> q) {
        int n = q.size();
        int half = n / 2;
        Queue<Integer> temp = new LinkedList<>();
        
        for (int i = 0; i < half; i++) {
            temp.add(q.poll());
        }
        
        while (!temp.isEmpty()) {
            q.add(temp.poll());
            q.add(q.poll());
        }
        
        return new ArrayList<>(q);
    }
}