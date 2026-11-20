import java.util.*;

class LC1046_LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i:stones){
            pq.offer(i);
        }
        while(pq.size()>1){
            int a=pq.poll();
            int b=pq.poll();
            if(a-b!=0){
                pq.offer(a-b);
            }
        }
        if(pq.size()==0){
            return 0;
        }
        else{
            return pq.poll();
        }
    }
}