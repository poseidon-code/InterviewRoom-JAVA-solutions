// PROBLEM: Postorder traversal
// https://www.interviewbit.com/problems/postorder-traversal/


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
    public ArrayList<Integer> postorder (Node root) {
        Stack<Node> s = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        Node last = new Node();

        if (root == null) return result;

        while (!s.isEmpty() || root!=null) {
            if (root!=null) {
                s.push(root);
                root = root.left;
            } else {
                Node temp = s.peek();

                if (temp.right!=null && last!=temp.right)
                    root = temp.right;
                else {
                    result.add(temp.data);
                    last = temp;
                    s.pop();
                }
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,null,2,null,null,3,null};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        var result = s.postorder(root);
        System.out.print("["); for (var x : result)
            {if (x==null) continue; System.out.print(x+" ");}
        System.out.println("\b]");
    }
}