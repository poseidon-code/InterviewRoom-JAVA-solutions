// PROBLEM: Minimum distance between two nodes
// https://practice.geeksforgeeks.org/problems/min-distance-between-two-given-nodes-of-a-binary-tree/1

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


    public Node lca (Node root, Node p, Node q) {
        if (root==null || root==p || root==q) return root;
        Node left = lca(root.left, p, q);
        Node right = lca(root.right, p, q);
        return left==null ? right : right==null ? left : root;
    }

    public int traverse (Node root, Node a) {
        if (root==null) return 0;
        if (root.data==a.data) return 1;
        int c = traverse(root.left, a);
        int d = traverse(root.right, a);
        if (c==0 && d==0) return 0;
        else return c+d+1;
    }
    
    // SOLUTION
    public int distance (Node root, Node p, Node q) {
        Node n = lca(root, p, q);

        int c = traverse(n, p);
        int d = traverse(n, q);

        return c+d-2;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {3,5,1,6,2,0,8,null,null,7,4};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);
        var p = root.left;
        var q = root.right;

        // OUTPUT :
        System.out.println(s.distance(root, p, q));
    }
}