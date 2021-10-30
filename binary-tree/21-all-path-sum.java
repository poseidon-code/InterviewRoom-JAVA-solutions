// PROBLEM: All Root to Leaf path sum
// https://leetcode.com/problems/path-sum-ii/
// https://www.interviewbit.com/problems/root-to-leaf-paths-with-sum/

import java.util.LinkedList;
import java.util.List;

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
    public void traverse (Node root, int target, List<Integer> path, List<List<Integer>> paths) {
        if (root==null) return;
        path.add(root.data);

        if (root.left==null && root.right==null && target==root.data) {
            paths.add(new LinkedList<>(path));
            path.remove(path.size()-1);
            return;
        } else {            
            traverse(root.left, target - root.data, path, paths);
            traverse(root.right, target - root.data, path, paths);
        }
        
        path.remove(path.size()-1);
    }

    public List<List<Integer>> all_path_sum (Node root, int target) {
        List<List<Integer>> paths = new LinkedList<List<Integer>>();
        List<Integer> path = new LinkedList<Integer>();

        traverse(root, target, path, paths);
        return paths;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,2};
        int target = 3;
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        var result = s.all_path_sum(root, target);
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