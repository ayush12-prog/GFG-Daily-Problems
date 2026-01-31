class kQueues {
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int freeSpot;

    public kQueues(int n, int k) {
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];
        
        Arrays.fill(front, -1);
        Arrays.fill(rear, -1);
        
        freeSpot = 0;
        for (int i = 0; i < n - 1; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    public void enqueue(int x, int i) {
        if (freeSpot == -1) {
            return;
        }
        
        int index = freeSpot;
        freeSpot = next[index];
        
        if (front[i] == -1) {
            front[i] = index;
        } else {
            next[rear[i]] = index;
        }
        
        next[index] = -1;
        rear[i] = index;
        arr[index] = x;
    }

    public int dequeue(int i) {
        if (front[i] == -1) {
            return -1;
        }
        
        int index = front[i];
        front[i] = next[index];
        
        next[index] = freeSpot;
        freeSpot = index;
        
        return arr[index];
    }

    public boolean isEmpty(int i) {
        return front[i] == -1;
    }

    public boolean isFull() {
        return freeSpot == -1;
    }
}