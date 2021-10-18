// PROBLEM: Populating next right pointers
// https://leetcode.com/problems/populating-next-right-pointers-in-each-node/


class Solution {
    static class Node {
        Integer data;
        Node left;
        Node right;
        Node next;

        Node() {this.data=0;};
        Node(Integer x) {this.data=x;};
        Node(Integer x, Node left, Node right, Node next) {this.data=x; this.left=left; this.right=right; this.next=next;};
    }

    static Node NBT (Integer[] elements, Node root, int i, int n) {
        if (n==0) return null;
    
        if (i<n) {
            Node temp = new Node(elements[i]);
            root = temp;
            root.left = NBT(elements, root.left, 2*i+1, n);
            root.right = NBT(elements, root.right, 2*i+2, n);
        }

        return root;
    }


    // SOLUTION
    public void connect (Node root) {
        while (root!=null && root.left!=null) {
            Node c = root;
            while (c!=null) {
                c.left.next = c.right;
                c.right.next = c.next!=null ? c.next.left : null;
                c = c.next;
            }
            root = root.left;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,3,4,5,6,7};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        s.connect(root);
    }
}