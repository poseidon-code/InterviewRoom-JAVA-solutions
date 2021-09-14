// PROBLEM: Check if a linked list is palindrome
// https://leetcode.com/problems/palindrome-linked-list/
// https://www.interviewbit.com/problems/palindrome-list/


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
    public boolean is_palidrome (Node head) {
        Node rev = null;
        Node slow = head, fast = head;

        while (fast!=null && fast.next!=null) {
            Node t = rev;
            fast = fast.next.next;
            rev = slow;
            slow = slow.next;
            rev.next = t;
        }

        if (fast!=null) 
            slow = slow.next;

        while (rev!=null && rev.data == slow.data) {
            slow = slow.next;
            rev = rev.next;
        }

        return rev==null;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        LinkedList ll = new LinkedList();
        ll.add(1);
        ll.add(2);
        ll.add(3);
        ll.add(3);
        ll.add(2);
        ll.add(1);
        var head = ll.get_head();

        // OUTPUT :
        if (s.is_palidrome(head)) 
            System.out.println("true");
        else
            System.out.println("false");
    }
}