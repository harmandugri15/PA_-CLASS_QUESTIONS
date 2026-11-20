import java.util.*;

class LC933_NumberOfRecentCalls {
    Queue <Integer> q1;
    public LC933_NumberOfRecentCalls() {
        q1=new LinkedList<>();
    }
    
    public int ping(int t) {    
        q1.add(t);
        while(q1.peek()<t-3000){
            q1.poll();
        }
        return q1.size();
    }
}

/**
 * Your LC933_NumberOfRecentCalls object will be instantiated and called as such:
 * LC933_NumberOfRecentCalls obj = new LC933_NumberOfRecentCalls();
 * int param_1 = obj.ping(t);
 */