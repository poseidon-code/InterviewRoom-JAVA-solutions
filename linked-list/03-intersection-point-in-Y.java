// PROBLEM: Intersection point in Y shaped linked list
// https://leetcode.com/problems/intersection-of-two-linked-lists/
// https://www.interviewbit.com/problems/intersection-of-linked-lists/


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

    
    public void createY(Node headA, Node headB, int skipA, int skipB) {
        Node pA = headA, pB = headB;
        for (int i=skipA; i>1; i--) pA = pA.next;
        for (int i=skipB; i>1; i--) pB = pB.next;
        pB.next = pA.next;
    }

    // SOLUTION
    public Node intersection (Node headA, Node headB) {
        Node pA = headA, pB = headB;

        if (pA == null || pB == null) return null;
    
        while (pA!=null && pB!=null && pA!=pB) {
            pA = pA.next;
            pB = pB.next;
    
            if (pA == pB) return pA;
            if (pA == null) pA = headB;
            if (pB == null) pB = headA;
        }
    
        return pA;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        LinkedList llA = new LinkedList();
        LinkedList llB = new LinkedList();
        llA.add(4); llA.add(1); llA.add(8); llA.add(4); llA.add(5);
        llB.add(5); llB.add(6); llB.add(1); llB.add(8); llB.add(4); llB.add(5);
        var headA = llA.get_head();
        var headB = llB.get_head();

        // OUTPUT :
        s.createY(headA, headB, 2, 3);
        var intersected = s.intersection(headA, headB);
        System.out.println("Intersected at " + intersected.data);
    }
}
