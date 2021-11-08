// PROBLEM: kth smallest node in BST
// https://leetcode.com/problems/kth-smallest-element-in-a-bst/


class Solution {
    static class Node {
        Integer data;
        Node left;
        Node right;

        Node() {this.data=0;};
        Node(Integer x) {this.data=x;};
        Node(Integer x, Node left, Node right) {this.data=x; this.left=left; this.right=right;};
    }

    static Node NBST (Integer[] elements, Node root, int i, int n) {
        if (n==0) return null;
    
        if (i<n) {
            Node temp = new Node(elements[i]);
            root = temp;
            root.left = NBST(elements, root.left, 2*i+1, n);
            root.right = NBST(elements, root.right, 2*i+2, n);
        }

        return root;
    }

    int result, value;

    public void traverse (Node root) {
        if (root==null || root.data==null) return;
        traverse(root.left);
        value--;
        if (value==0) result = root.data;
        traverse(root.right);
    }

    // SOLUTION
    public int kth_smallest (Node root, int k) {
        value = k; 
        traverse(root);
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {3,1,4,null,2};
        int k = 1;
        Node root = NBST(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.kth_smallest(root, k));
    }
}