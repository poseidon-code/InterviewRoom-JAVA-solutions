// PROBLEM: Reverse list in a group of given size k
// https://leetcode.com/problems/reverse-nodes-in-k-group/
// https://www.interviewbit.com/problems/k-reverse-linked-list/


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
    public Node reverse (Node first, Node last) {
        Node p = last;
        while (first!=last) {
            var t = first.next;
            first.next = p;
            p = first;
            first = t;
        }
        return p;
    }

    public Node reverse_group (Node head, int k) {
        Node node = head;

        for (int i=0; i<k; i++) {
            if (node==null)
                return head;
            node = node.next;
        }

        var new_head = reverse(head, node);
        head.next = reverse_group(node, k);

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
        var reversed = s.reverse_group(head, 2);
        ll.print(reversed);
    }
}