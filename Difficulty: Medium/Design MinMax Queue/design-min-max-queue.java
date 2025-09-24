class SpecialQueue {

    private Queue<Integer> mainQueue;
    private Deque<Integer> minDeque;
    private Deque<Integer> maxDeque;

    public SpecialQueue() {
        mainQueue = new LinkedList<>();
        minDeque = new LinkedList<>();
        maxDeque = new LinkedList<>();
    }

    public void enqueue(int x) {
        mainQueue.add(x);

        while (!minDeque.isEmpty() && minDeque.peekLast() > x) {
            minDeque.removeLast();
        }
        minDeque.addLast(x);

        while (!maxDeque.isEmpty() && maxDeque.peekLast() < x) {
            maxDeque.removeLast();
        }
        maxDeque.addLast(x);
    }

    public void dequeue() {
        int frontElement = mainQueue.peek();
        mainQueue.remove();

        if (frontElement == minDeque.peekFirst()) {
            minDeque.removeFirst();
        }

        if (frontElement == maxDeque.peekFirst()) {
            maxDeque.removeFirst();
        }
    }

    public int getFront() {
        return mainQueue.peek();
    }

    public int getMin() {
        return minDeque.peekFirst();
    }

    public int getMax() {
        return maxDeque.peekFirst();
    }
}
