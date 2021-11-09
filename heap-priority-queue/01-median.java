// PROBLEM: Find median in a stream
// https://practice.geeksforgeeks.org/problems/find-median-in-a-stream-1587115620/1

import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    static double median;
    static PriorityQueue<Integer> minq = new PriorityQueue<Integer>();
    static PriorityQueue<Integer> maxq = new PriorityQueue<Integer>(Collections.reverseOrder());

    // SOLUTION
    public static void balance_heaps () {
        if (Math.abs(maxq.size() - minq.size()) > 1) {
            if (maxq.size() > minq.size()) {
                minq.add(maxq.peek());
                maxq.poll();
            } else {
                maxq.add(minq.peek());
                minq.poll();
            }
        }
    }

    public void insert_heap (int x) {
        if (maxq.isEmpty())
            maxq.add(x);
        else if (x > maxq.peek())
            minq.add(x);
        else if (minq.isEmpty()) {
            minq.add(maxq.peek());
            maxq.poll();
            maxq.add(x);
        }
        else
            maxq.add(x);

        balance_heaps();
    }
    
    public double get_median() {
        if ((maxq.size() + minq.size())%2 == 0) {
            median = (minq.peek()+maxq.peek());
            median /= 2.0;
        } else {
            if (minq.isEmpty())
                median = maxq.peek();
            else if (minq.size() < maxq.size())
                median = maxq.peek();
            else
                median = minq.peek();
        }

        return median;
    }

    
    public static void main(String[] args) {
        Solution s = new Solution();
        
        // INPUT :
        Integer[] x = {5,15,1,3};

        // OUTPUT :
        for (var i : x) {
            s.insert_heap(i);
            System.out.println(s.get_median());
        }
    }
}