// PROBLEM: Reorder list
// https://leetcode.com/problems/reorder-list/
// https://www.interviewbit.com/problems/reorder-list/


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
    public Node reorder (Node head) {
        if (head==null || head.next==null) 
            return head;

        Node prev=null, slow=head, fast=head, l1=head, l2=null;

        while (fast!=null && fast.next!=null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;

        Node p=null, c=slow, n=null;
        while (c!=null) {
            n=c.next;
            c.next=p;
            p=c;
            c=n;
        }
        l2 = p;

        while (l1!=null) {
            Node n1=l1.next, n2=l2.next;
            l1.next = l2;

            if (n1==null) break;

            l2.next = n1;
            l1 = n1;
            l2 = n2;
        }

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
        var result = s.reorder(head);
        ll.print(result);
    }
}