// PROBLEM: Segregate even and odd positioned nodes in linked list
// https://leetcode.com/problems/odd-even-linked-list/
// https://practice.geeksforgeeks.org/problems/rearrange-a-linked-list/1


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
    public Node oddeven (Node head) {
        if (head==null || head.next==null) 
            return head;

        Node odd = head, even = head.next;

        if (even.next==null)
            return head;

        Node c = even.next, e = even;

        while (c!=null) {
            odd.next = c;
            e.next = c.next;
            odd = odd.next;
            e = e.next;

            if (e!=null) c = e.next;
            else break;
        }

        odd.next = even;
        return head;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(4);
        ll.add(5);
        ll.add(6);
        ll.add(7);
        ll.add(8);
        ll.add(9);
        var head = ll.get_head();

        // OUTPUT :
        var result = s.oddeven(head);
        ll.print(result);
    }
}