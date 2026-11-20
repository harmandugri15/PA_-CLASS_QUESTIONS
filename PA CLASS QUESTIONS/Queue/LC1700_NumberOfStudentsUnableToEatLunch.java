import java.util.*;

class LC1700_NumberOfStudentsUnableToEatLunch {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q=new LinkedList<>();
        for(int i:students){
            q.add(i);
        }
        int st=0;
        int rot=0;
        while(!q.isEmpty() && rot<q.size()){
            if(q.peek()==sandwiches[st]){
                q.poll();
                st++;
                rot=0;
            }
            else{
                q.add(q.poll());
                rot++;
            }
        }
        
        return q.size();

    }
}