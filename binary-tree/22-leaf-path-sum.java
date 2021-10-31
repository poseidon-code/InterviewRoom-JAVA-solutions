// PROBLEM: Maximum path sum between two leaf nodes
// https://www.codingninjas.com/codestudio/problems/maximum-path-sum-between-two-leaves_794950

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
    public int traverse (Node root, int result) {
        if (root==null) return 0;
        if (root.left==null && root.right==null) return root.data;

        int ls = traverse(root.left, result);
        int rs = traverse(root.right, result);

        if (root.left!=null && root.right!=null) {
            result = Math.max(result, ls+rs+root.data);
            return Math.max(ls, rs) + root.data;
        }

        return root.left==null ? rs+root.data : ls+root.data;        
    }

    public int leaf_path_sum (Node root) {
        int result = Integer.MIN_VALUE;
        int v = traverse(root, result);

        if (result==Integer.MIN_VALUE) return v;
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,3};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.leaf_path_sum(root));
    }
}