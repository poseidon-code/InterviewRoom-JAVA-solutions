// PROBLEM: Invert a binary tree
// https://leetcode.com/problems/invert-binary-tree/
// https://www.interviewbit.com/problems/invert-the-binary-tree/

import java.util.Stack;

class Solution {
    static class Node {
        Integer data;
        Node left;
        Node right;

        Node() {this.data=0;};
        Node(Integer x) {this.data=x;};
        Node(Integer x, Node left, Node right) {this.data=x; this.left=left; this.right=right;};
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
    public Node invert (Node root) {
        Stack<Node> s = new Stack<>();
        s.push(root);

        while (!s.isEmpty()) {
            Node p = s.pop();
            if (p!=null) {
                s.push(p.left);
                s.push(p.right);
                var t = p.left;
                p.left = p.right;
                p.left = t;
            }
        }

        return root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {4,2,7,1,3,6,9};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        s.invert(root);
    }
}