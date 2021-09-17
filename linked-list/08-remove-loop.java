// PROBLEM: Detect and remove loop in linked list
// https://leetcode.com/problems/linked-list-cycle-ii/
// https://www.interviewbit.com/problems/list-cycle/

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
    public void loop (Node head, int p) {
        if (head.next==null) return;
        if (p==-1) return;

        Node tail = head, node = head;
        while (tail.next!=null) tail = tail.next;
        for (int i=0; i<p; i++) node = node.next;

        tail.next = node;
    }

    public Node remove_loop (Node head) {
        if (head==null || head.next==null) 
            return null;

        Node slow = head, fast = head, entry = head;

        while (fast.next!=null && fast.next.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow==fast) {
                while (slow  != entry) {
                    slow = slow.next;
                    entry = entry.next;
                }
                return entry;
            }
        }

        return null;
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
        s.loop(head, 1);

        // OUTPUT :
        var removed = s.remove_loop(head);
        if (removed==null) System.out.println("no cycle");
        else System.out.println("cycle at node valued " + removed.data);
    }
}