// PROBLEM: Least Common Ancestor of two nodes
// https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

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
    public Node lca (Node root, Node p, Node q) {
        if (root==null || root==p || root==q) return root;

        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);

        return left==null ? right : right==null ? left : root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {3,5,1,6,2,0,8,null,null,7,4};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);
        var p = root.left;
        var q = root.right;

        // OUTPUT :
        System.out.println(s.lca(root, p, q).data);
    }
}