// PROBLEM: Remove nth node from the end
// https://leetcode.com/problems/remove-nth-node-from-end-of-list/
// https://www.interviewbit.com/problems/remove-nth-node-from-list-end/


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
    public Node remove_nth (Node head, int n) {
        Node slow = head, fast = head;

        for (int i=1; i<=n+1; i++)
        fast = fast.next;

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

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
        var head = ll.get_head();

        // OUTPUT :
        var new_head = s.remove_nth(head, 2);
        ll.print(new_head);
    }
}
