// PROBLEM: Right view of binary tree
// https://leetcode.com/problems/binary-tree-right-side-view/


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
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
    public ArrayList<Integer> right_view (Node root) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i=0; i<size; i++) {
                Node t = q.poll();
                if (i==size-1) result.add(t.data);
                if (t.left!=null) q.add(t.left);
                if (t.right!=null) q.add(t.right);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,3,null,5,null,4};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        var result = s.right_view(root);
        System.out.print("["); for (var x : result)
            {if (x==null) continue; System.out.print(x+" ");}
        System.out.println("\b]");
    }
}