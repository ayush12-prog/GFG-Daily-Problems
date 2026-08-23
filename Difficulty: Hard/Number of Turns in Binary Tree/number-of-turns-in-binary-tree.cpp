/* Structure of Binary Tree Node
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
}; */

class Solution {
    int ans = 0;
    int p1;
    int q1;
    int find(Node*root,int dir){ // apply post order

        // 0 = neither node found
        // 1 = one node found path still active
        // 2 = both node found path completely resolved.

        if(!root)return 0;

        int left = find(root->left,0);
        int right = find(root->right,1);


        if(root->data==p1 || root->data==q1){ // if you are given node then check below you
            if(left || right)return 2; // if node present then you are the meeting point do not check anymore
            else return 1;// you are the first node founded
        }
        else if(right==0 && left==0)return 0;// not found any node yet
        else if(right && left){ // you are the perfect meeting point do not check anymore
            ans++;
            return 2;
        }
        else if(left==2 || right==2)return 2; //node not present in the path
        else{ // check the node for direction

            if(left && dir!=0)ans++;
            if(right && dir!=1)ans++;

            return 1;

        }

    }
  public:
    int numberOfTurns(Node* root, int p, int q) {
        // code here
        p1 = p;
        q1 = q;
        if(p==q)return -1;
        find(root,-1);

        return (ans==0)?-1:ans;
    }
};