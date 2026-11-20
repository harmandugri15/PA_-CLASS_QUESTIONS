import java.util.*;

class LC2073_TimeNeededToBuyTickets {
    public int timeRequiredToBuy(int[] tickets, int k) {
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<tickets.length;i++){
            q.add(i);
        }
        int rotations=0;
        while(tickets[k]!=0){
            int x=q.poll();
            tickets[x]--;
            rotations++;
            if(tickets[x]>0){
                q.add(x);
            }
        }
        return rotations;
    }
}