// PROBLEM: Convert binary tree to its mirror tree
// https://practice.geeksforgeeks.org/problems/mirror-tree/1


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
    public void mirror (Node root) {
        if (root==null) return;
        else {
            Node t = new Node();
            mirror(root.left);
            mirror(root.right);
            t = root.left;
            root.left = root.right;
            root.right = t;
        }
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,3,2,null,null,5,4};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        s.mirror(root);
    }
}