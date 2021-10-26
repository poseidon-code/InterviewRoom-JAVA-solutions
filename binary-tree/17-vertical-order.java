import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// PROBLEM: Vertical order traversal
// https://www.interviewbit.com/problems/vertical-order-traversal-of-binary-tree/

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
    List<int[]> m = new ArrayList<>();
    public void traverse (Node root, int x, int y) {
        if (root!=null) {
            m.add(new int[]{root.data, x, y});
            traverse(root.left, x-1, y-1);
            traverse(root.right, x+1, y-1);
        }
    }

    public List<List<Integer>> vertical (Node root) {
        traverse(root, 0, 0);
        List<List<Integer>> result = new ArrayList<>();
        
        m.sort(new Comparator<int[]>() {
            public int compare(int[] a, int[] b){
                if (a[1]!=b[1])
                    return a[1]-b[1];
                else if (a[2]!=b[2])
                    return -a[2]+b[2]; 
                else
                    return a[0]-b[0];
            }
        });

        for(int i=0; i<m.size(); i++) {
            int j = i;
            while(j<m.size() && m.get(j)[1]==m.get(i)[1])  j++;
            
            List<Integer> t = new ArrayList<>();
            for(int z=i; z<j; z++)
                t.add(m.get(z)[0]);
            
            result.add(t);
            i=j-1;
        }
        
        return result;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] elements = {1,2,3,4,5,6,7};
        Node root = NBT(elements, new Node(elements[0]), 0, elements.length);

        // OUTPUT :
        var result  = s.vertical(root);
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