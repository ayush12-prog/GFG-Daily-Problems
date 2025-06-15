/*
class Node{
    int data;
    Node left;
    Node right;
    Node(int data){
        this.data = data;
        left=null;
        right=null;
    }
}

*/
class Solution {
    boolean isSym(Node a, Node b){
        if(a==null||b==null) return a==b;
        if(a.data!=b.data) return false;
        return isSym(a.left,b.right)&&isSym(a.right,b.left);
    }
    public boolean isSymmetric(Node r){
        return r==null||isSym(r.left,r.right);
    }
}