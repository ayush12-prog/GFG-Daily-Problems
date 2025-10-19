/*
class Node {
  public:
    int data;
    Node* left;
    Node* right;

    Node(int val) {
        data = val;
        left = NULL;
        right = NULL;
    }
};
*/

class Solution {
  public:
    vector<int> getKClosest(Node* root, int target, int k) {
        vector<int> vals;
        stack<Node*> st;
        Node* curr = root;
        while (curr || !st.empty()) {
            while (curr) {
                st.push(curr);
                curr = curr->left;
            }
            curr = st.top();
            st.pop();
            vals.push_back(curr->data);
            curr = curr->right;
        }

        sort(vals.begin(), vals.end(), [&](int a, int b) {
            int diffA = abs(a - target);
            int diffB = abs(b - target);
            if (diffA == diffB) return a < b;
            return diffA < diffB;
        });

        return vector<int>(vals.begin(), vals.begin() + k);
    }
};
