// PROBLEM: Diameter of binary tree
// https://leetcode.com/problems/diameter-of-binary-tree/

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
    int d = 0;
    public int traverse (Node root) {
        if (root==null) return 0;
        int ld = traverse(root.left);
        int rd = traverse(root.right);
        d = Math.max(d, ld+rd);
        return Math.max(ld, rd)+1;
    }

    public int diameter (Node root) {
        traverse(root);
        return d;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,3,5,4};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.diameter(root));
    }
}