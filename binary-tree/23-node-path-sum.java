// PROBLEM: Maximum path sum from any node to node
// https://leetcode.com/problems/binary-tree-maximum-path-sum/


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
    int max_sum = Integer.MIN_VALUE;

    public int traverse (Node root) {
        if (root==null) return 0;
        int c = root.data==null ? 0 : root.data;
        
        int ls = Math.max(traverse(root.left),0);
        int rs = Math.max(traverse(root.right),0);
        max_sum = Math.max(max_sum, ls+rs+c);
        return Math.max(ls, rs) + c;
    }

    public int node_path_sum (Node root) {
        int v = traverse(root);

        if (max_sum==Integer.MIN_VALUE) return v;
        return max_sum;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {-10,9,20,null,null,15,7};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.node_path_sum(root));
    }
}