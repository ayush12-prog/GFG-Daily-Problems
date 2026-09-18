/* Binary Tree Node Structure
class Node {
public:
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
}; 
*/

class Solution {
public:
    int res;
    int prev;
    void solve(Node* root) {
        if (!root)
            return;

        solve(root->left);
        if (prev != INT_MIN)
            res = min(res, abs(root->data - prev));
        prev = root->data;
        solve(root->right);
    }
    int absDiff(Node* root) {
        res = INT_MAX;
        prev = INT_MIN;
        solve(root);
        return res;
    }
};