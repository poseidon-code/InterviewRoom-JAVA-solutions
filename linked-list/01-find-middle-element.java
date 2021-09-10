// SOLUTION: Find middle element
// https://leetcode.com/problems/middle-of-the-linked-list/
// https://practice.geeksforgeeks.org/problems/finding-middle-element-in-a-linked-list/1


class Solution {
    static class Node {
        int data;
        Node next;
    }

    static class LinkedList {
        private Node head, tail;

        public LinkedList() {
            head = null;
            tail = null;
        }

        public void add(int n) {
            Node t = new Node();
            t.data = n;
            t.next = null;

            if (head==null) {
                head=t;
                tail=t;
            } else {
                tail.next = t;
                tail = tail.next;
            }
        }

        public void print(Node start) {
            Node p;
            p = start;
            System.out.print("[");
            while (p != null) {
                System.out.print(p.data + " ");
                p=p.next;
            }
            System.out.println("\b]");
        }

        Node get_head() {
            return head;
        }
    }

    
    // SOLUTION
    public Node middle_node (Node head) {
        Node slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        LinkedList ll = new LinkedList();
        ll.add(0);
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        var head = ll.get_head();

        // OUTPUT :
        var start = s.middle_node(head);
        ll.print(start);
    }
}
