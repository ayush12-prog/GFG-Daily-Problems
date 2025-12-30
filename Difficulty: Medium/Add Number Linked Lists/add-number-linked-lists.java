/*
class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}
*/

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        num1 = reverse(num1);
        num2 = reverse(num2);
        
        Node sumHead = null;
        int carry = 0;
        
        while (num1 != null || num2 != null || carry != 0) {
            int val1 = (num1 != null) ? num1.data : 0;
            int val2 = (num2 != null) ? num2.data : 0;
            
            int sum = val1 + val2 + carry;
            int digit = sum % 10;
            carry = sum / 10;
            
            Node newNode = new Node(digit);
            newNode.next = sumHead;
            sumHead = newNode;
            
            if (num1 != null) num1 = num1.next;
            if (num2 != null) num2 = num2.next;
        }
        
        while (sumHead != null && sumHead.data == 0 && sumHead.next != null) {
            sumHead = sumHead.next;
        }
        
        return sumHead;
    }
    
    static Node reverse(Node head) {
        Node prev = null;
        Node curr = head;
        Node next;
        
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}