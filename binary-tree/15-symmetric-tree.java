// PROBLEM: Symmetric tree
// https://leetcode.com/problems/symmetric-tree/
// https://www.interviewbit.com/problems/symmetric-binary-tree/


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
    public boolean traverse (Node p, Node q) {
        if (p==null && q==null) return true;
        else if (p==null || q==null) return false;
        
        if (p.data != q.data) return false;
        
        return traverse(p.left,q.right) && traverse(p.right, q.left);
    }

    public boolean is_symmetric (Node root) {
        if (root==null) return true;
        return traverse(root.left, root.right);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,2,3,4,4,3};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.is_symmetric(root));
    }
}