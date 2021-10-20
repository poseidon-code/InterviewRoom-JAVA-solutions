// PROBLEM: Check if binary tree is balanced
// https://leetcode.com/problems/balanced-binary-tree/


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
    public int traverse (Node root) {
        if (root==null) return 0;
        return Math.max(traverse(root.left), traverse(root.right))+1;
    }

    public boolean is_balanced (Node root) {
        if (root==null) return true;

        int l = traverse(root.left);
        int r = traverse(root.right);

        return Math.abs(l-r) <= 1 && is_balanced(root.left) && is_balanced(root.right);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {9,3,20,null,null,15,7};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.is_balanced(root));
    }
}