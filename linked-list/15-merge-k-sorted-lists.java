// PROBLEM: Merge k sorted lists
// https://leetcode.com/problems/merge-k-sorted-lists/
// https://www.interviewbit.com/problems/merge-two-sorted-lists/
// https://practice.geeksforgeeks.org/problems/merge-k-sorted-linked-lists/1


import java.util.PriorityQueue;


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
    public Node merge_sorted (Node[] lists) {
        PriorityQueue<Node> heap = new PriorityQueue<>(lists.length, (l,r)-> l.data - r.data);
        Node head = new Node();
        Node c = head;

        for (Node node : lists)
            if (node!=null)
                heap.add(node);

        while (!heap.isEmpty()) {
            c.next = heap.poll();
            c = c.next;
            if (c.next!=null) heap.add(c.next);
        }

        return head.next;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        LinkedList ll1 = new LinkedList();
        LinkedList ll2 = new LinkedList();
        LinkedList ll3 = new LinkedList();
        ll1.add(1);
        ll1.add(4);
        ll1.add(5);
        ll2.add(1);
        ll2.add(3);
        ll2.add(4);
        ll3.add(2);
        ll3.add(6);
        var h1 = ll1.get_head();
        var h2 = ll2.get_head();
        var h3 = ll3.get_head();

        Node[] lists = {h1, h2, h3};

        // OUTPUT :
        var result = s.merge_sorted(lists);
        ll1.print(result);
    }
}