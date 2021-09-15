// PROBLEM: Rotate a linked list
// https://leetcode.com/problems/rotate-list/
// https://www.interviewbit.com/problems/rotate-list/


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
    public Node rotate (Node head, int k) {
        if (head==null) return head;

        int l = 1;
        Node new_head = head, tail = head;

        while (tail.next!=null) {
            tail = tail.next;
            l++;
        }
        tail.next = head;

        if (k%l == k)
            for (int i=0; i<l-k; i++)
                tail = tail.next;

        new_head = tail.next;
        tail.next = null;

        return new_head;
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
        var head = ll.get_head();

        // OUTPUT :
        var rotated = s.rotate(head, 2);
        ll.print(rotated);
    }
}