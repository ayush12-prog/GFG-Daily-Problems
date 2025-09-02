/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
        int n = 0;
        Node temp = head;
        while (temp != null) {
            n++;
            temp = temp.next;
        }

        if (k > n) return head;

        Node first = head, second = head;
        for (int i = 1; i < k; i++) {
            first = first.next;
        }
        for (int i = 1; i < n - k + 1; i++) {
            second = second.next;
        }

        int t = first.data;
        first.data = second.data;
        second.data = t;

        return head;
    }
}