// PROBLEM: Segregate even and odd valued nodes in a linked list 
// https://www.geeksforgeeks.org/segregate-even-and-odd-elements-in-a-linked-list/


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
    public Node oddeven_values (Node head) {
        if (head==null || head.next==null) 
            return head;

        Node es=null, ee=null, os=null, oe=null;
        Node c = head;

        while(c!=null) {
            int val = c.data;

            if (val%2 == 0) {
                if (es==null) {
                    es = c;
                    ee = es;
                } else {
                    ee.next = c;
                    ee = ee.next;
                }
            } else {
                if (os==null) {
                    os = c;
                    oe = os;
                } else {
                    oe.next = c;
                    oe = oe.next;
                }
            }

            c = c.next;
        }

        if (os==null || es==null) return null;

        ee.next = os;
        oe.next = null;

        return es;
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
        var result = s.oddeven_values(head);
        ll.print(result);
    }
}