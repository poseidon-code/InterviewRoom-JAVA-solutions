// PROBLEM: Path sum
// https://www.interviewbit.com/problems/path-sum/
// https://leetcode.com/problems/path-sum/

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
    public boolean has_path_sum (Node root, int target) {
        if (root==null) return false;

        if (root.left == root.right) return target == root.data;

        return has_path_sum(root.left, target - root.data) || has_path_sum(root.right, target - root.data);
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,3};
        int target = 3;
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        System.out.println(s.has_path_sum(root, target));
    }
}