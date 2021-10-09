// PROBLEM: Maximum height of binary tree
// https://leetcode.com/problems/maximum-depth-of-binary-tree/
// https://www.interviewbit.com/problems/max-depth-of-binary-tree/


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
    public int maximum_height (Node root) {
        if (root==null) {
            return 0;
        } else {
            return Math.max(maximum_height(root.left), maximum_height(root.right)+1);
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {3,9,20,null,null,15,7};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.maximum_height(root));
    }
}