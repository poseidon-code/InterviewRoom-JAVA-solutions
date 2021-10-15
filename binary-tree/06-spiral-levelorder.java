// PROBLEM: Level order traversal in sipral form
// https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
// https://www.interviewbit.com/problems/zigzag-level-order-traversal-bt/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


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
    public ArrayList<ArrayList<Integer>> levelorder_spiral (Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        boolean l2r = true;

        if (root == null) return result;

        q.add(root);

        while (!q.isEmpty()) {
            ArrayList<Integer> row = new ArrayList<>();
            int s = q.size();

            for (int i=0; i<s; i++) {
                Node t = q.poll();

                if (l2r) row.add(t.data);
                else row.add(0, t.data);
                
                if (t.left!=null) q.add(t.left);
                if (t.right!=null) q.add(t.right);
            }

            l2r = !l2r;
            result.add(row);
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {3,9,20,null,null,15,7};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        var result = s.levelorder_spiral(root);
        System.out.print("[");
        for (var x : result) {
            System.out.print("[");
            for (var y : x) {
                if (y==null) continue;
                System.out.print(y+",");
            }
            System.out.print("\b],");
        }
        System.out.println("\b]");
    }
}