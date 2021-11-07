// PROBLEM: Inorder successor in BST
// https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1


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
    public Node inorder_successor (Node root, Node x) {
        Node s = null;
        while(root!=null) {
            if(x.data>=root.data)
                root=root.right;
            else {
                s = root;
                root=root.left;
            }
        }

        return s;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {2,1,3};
        Node root = NBST(elements, new Node(elements[0]), 0, elements.length);
        Node x = root.left;

        // OUTPUT :
        System.out.println(s.inorder_successor(root, x).data);
    }
}