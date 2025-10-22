class Solution {
public:
    void nearlySorted(vector<int>& arr, int k) {
        priority_queue<int, vector<int>, greater<int>> minHeap;
        int n = arr.size();
        int index = 0;

        for (int i = 0; i <= k && i < n; i++) {
            minHeap.push(arr[i]);
        }

        for (int i = k + 1; i < n; i++) {
            arr[index++] = minHeap.top();
            minHeap.pop();
            minHeap.push(arr[i]);
        }

        while (!minHeap.empty()) {
            arr[index++] = minHeap.top();
            minHeap.pop();
        }
    }
};