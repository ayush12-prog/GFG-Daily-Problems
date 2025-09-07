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
    public Node mergeKLists(Node[] arr) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.data - b.data);

        for (Node head : arr) {
            if (head != null) pq.add(head);
        }

        Node dummy = new Node(0);
        Node tail = dummy;

        while (!pq.isEmpty()) {
            Node min = pq.poll();
            tail.next = min;
            tail = tail.next;

            if (min.next != null) pq.add(min.next);
        }

        return dummy.next;
    }
}