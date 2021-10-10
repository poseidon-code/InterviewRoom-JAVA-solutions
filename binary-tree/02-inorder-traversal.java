// PROBLEM: Inorder traversal
// https://www.interviewbit.com/problems/inorder-traversal/


import java.util.ArrayList;
import java.util.Stack;

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
    public ArrayList<Integer> inorder (Node root) {
        Stack<Node> s = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        Node c = root.left;
        s.push(root);

        while (!s.isEmpty() || c!=null) {
            while (c!=null) {
                s.push(c);
                c=c.left;
            }

            Node temp = s.pop();
            result.add(temp.data);
            c = temp.right;
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,6,2,null,null,3,null};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        var result = s.inorder(root);
        System.out.print("["); for (var x : result)
            {if (x==null) continue; System.out.print(x+" ");}
        System.out.println("\b]");
    }
}