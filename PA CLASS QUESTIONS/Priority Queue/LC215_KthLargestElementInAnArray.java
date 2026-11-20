import java.util.*;

class LC215_KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue();
        for(int i:nums){
            pq.add(i);
        }
        int index=0;
        while(pq.size()>k){
            pq.poll();
            index++;
        }
        return pq.poll();
    }
}