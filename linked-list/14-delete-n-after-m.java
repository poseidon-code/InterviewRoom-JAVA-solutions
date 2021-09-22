// PROBLEM: Delete N nodes after M nodes of a linked list
// https://practice.geeksforgeeks.org/problems/delete-n-nodes-after-m-nodes-of-a-linked-list/1


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
    public Node delete_nodes (Node head, int m, int n) {
        Node c=head, t=null;

        while (c!=null) {
            int i, count;

            for (i=1; i<m && c!=null; i++)
                c = c.next;
            
            if (c==null) return head;

            t = c.next;
            for (count=1; count<=n && t!=null; count++) {
                t=t.next;
            }
            c.next = t;
            c=t;
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
        var result = s.delete_nodes(head, 2, 5);
        ll.print(result);
    }
}