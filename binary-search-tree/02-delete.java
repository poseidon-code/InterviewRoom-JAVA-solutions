// PROBLEM: Delete node from BST
// https://leetcode.com/problems/delete-node-in-a-bst/


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

    public Node min (Node node) {
        while (node.left != null)
            node = node.left;
        return node;
    }
    
    // SOLUTION
    public Node delete_node (Node root, int key) {
        if (root==null) return null;

        if(key<root.data)
            root.left = delete_node(root.left, key);
        else if(key>root.data)
            root.right = delete_node(root.right, key);
        else {
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            
            Node minNode = min(root.right);
            root.data = minNode.data;
            root.right = delete_node(root.right, root.data);
        }
        
        return root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {5,3,6,2,4,null,7};
        int key = 3;
        Node root = NBST(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        s.delete_node(root, key);
    }
}