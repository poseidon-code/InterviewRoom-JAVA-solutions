// PROBLEM: Bottom view of binary tree
// https://practice.geeksforgeeks.org/problems/bottom-view-of-binary-tree/1


import java.util.ArrayList;
import java.util.HashMap;
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
    class pair {
        Node n; int l;
        pair(Node n, int l) { this.n = n; this.l = l; }
    }

    public ArrayList<Integer> bottom_view (Node root) {
        int minlevel=0, maxlevel=0;

        ArrayList<Integer> result = new ArrayList<>();
        Queue<pair> q = new LinkedList<>();
        HashMap<Integer, Integer> m = new HashMap<>();
        q.add(new pair(root, 0));
        

        while (q.size()!=0) {
            Node x = q.peek().n;
            int p = q.peek().l;
            q.poll();

            if (!m.containsKey(p)) {
                m.put(p, x.data);
                if(minlevel>p) minlevel = p;
                if(maxlevel<p) maxlevel = p;
            }
            if (x.left!=null) q.add(new pair(x.left, p-1));
            if (x.right!=null) q.add(new pair(x.right, p+1));
        }

        for (int i=minlevel; i<=maxlevel; i++)
            if (m.containsKey(i)) result.add(m.get(i));

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,3};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        var result = s.bottom_view(root);
        System.out.print("["); for (var x : result)
            {if (x==null) continue; System.out.print(x+" ");}
        System.out.println("\b]");
    }
}