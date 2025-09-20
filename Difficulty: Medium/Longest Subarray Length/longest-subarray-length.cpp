class Solution {
 public:
  int longestSubarray(std::vector<int>& arr) {
    int n = arr.size();
    if (n == 0) {
      return 0;
    }

    std::vector<int> left(n);
    std::stack<int> s;
    for (int i = 0; i < n; ++i) {
      while (!s.empty() && arr[s.top()] <= arr[i]) {
        s.pop();
      }
      left[i] = s.empty() ? -1 : s.top();
      s.push(i);
    }

    while (!s.empty()) {
        s.pop();
    }

    std::vector<int> right(n);
    for (int i = n - 1; i >= 0; --i) {
      while (!s.empty() && arr[s.top()] < arr[i]) {
        s.pop();
      }
      right[i] = s.empty() ? n : s.top();
      s.push(i);
    }

    int max_len = 0;
    for (int i = 0; i < n; ++i) {
      int width = right[i] - left[i] - 1;
      if (arr[i] <= width) {
        max_len = std::max(max_len, width);
      }
    }

    return max_len;
  }
};

