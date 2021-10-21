// PROBLEM: Check if a binary tree is BST
// https://practice.geeksforgeeks.org/problems/check-for-bst/1


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
    public boolean traverse (Node root, Node min, Node max) {
        if (root==null) return true;
        if (min!=null && root.data<=min.data) return false;
        if (max!=null && root.data>=max.data) return false;

        boolean l = traverse(root.left, min, root);
        boolean r = traverse(root.right, root, max);

        return l && r;
    }

    public boolean is_bst (Node root) {
        return traverse(root, null, null);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {2,1,3};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.is_bst(root));
    }
}