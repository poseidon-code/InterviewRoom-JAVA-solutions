// PROBLEM: Add two numbers
// https://leetcode.com/problems/add-two-numbers/
// https://www.interviewbit.com/problems/add-two-numbers-as-lists/


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
    public Node add (Node l1, Node l2) {
        Node head = new Node();
        Node t = head;
        int c = 0;

        while (c!=0 || l1!=null || l2!=null) {
            c += (l1!=null ? l1.data : 0) + (l2!=null ? l2.data : 0);

            Node temp = new Node();
            temp.data = c%10;
            temp.next = null;

            t.next = temp;
            t = t.next;
            c /= 10;

            if (l1!=null) l1 = l1.next;
            if (l2!=null) l2 = l2.next;
        }

        return head.next;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        ll1.add(2);
        ll1.add(4);
        ll1.add(3);
        ll2.add(5);
        ll2.add(6);
        ll2.add(4);
        var h1 = ll1.get_head();
        var h2 = ll2.get_head();

        // OUTPUT :
        var result = s.add(h1, h2);
        ll1.print(result);
    }
}