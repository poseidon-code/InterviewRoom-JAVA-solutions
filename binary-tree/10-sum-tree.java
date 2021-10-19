// PROBLEM: Check if sum tree
// https://practice.geeksforgeeks.org/problems/sum-tree/1

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
    boolean result = true;
    public int traverse (Node root) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return root.data;

        int ld = traverse(root.left);
        int rd = traverse(root.right);
        
        if (ld+rd!=root.data) result = false;
        
        return root.data+ld+rd;
    }

    public boolean is_sum_tree (Node root) {
        traverse(root);
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {10,20,30,10,10};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.is_sum_tree(root));
    }
}