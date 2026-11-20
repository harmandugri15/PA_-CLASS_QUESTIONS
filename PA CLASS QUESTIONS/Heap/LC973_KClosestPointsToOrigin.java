import java.util.*;

class LC973_KClosestPointsToOrigin {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(
            (a,b)->( (b[0] * b[0] + b[1] * b[1] )  - (a[0] *a[0] + a[1] *a[1] ))
        );
        for(int[] i:points){
            pq.offer(i);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][] arr2=new int[k][2];
        for(int i=0;i<k;i++){
            arr2[i]=pq.poll();
        }

        return arr2;
    }
}