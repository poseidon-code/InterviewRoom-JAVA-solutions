// PROBLEM: Insert Node into binary search tree
// https://leetcode.com/problems/insert-into-a-binary-search-tree/


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

    
    // SOLUTION
    public Node insert (Node root, int value) {
        if (root==null) return new Node(value);
        Node c = root;
        while (true) {
            if (c.data<=value) {
                if (c.right!=null) c = c.right;
                else {
                    c.right = new Node(value);
                    break;
                }
            } else {
                if (c.left!=null) c = c.left;
                else {
                    c.left = new Node(value);
                    break;
                }
            }
        }
        return root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {4,2,7,1,3};
        int value = 5;
        Node root = NBST(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        s.insert(root, value);
    }
}