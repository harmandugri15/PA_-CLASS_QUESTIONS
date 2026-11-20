import java.util.*;

class LC621_TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++; // Fixed array indexing from 'A' to 0-25
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int f : freq) { // Note: iterate over freq values
            if (f > 0) {
                pq.offer(f);
            }
        }
        
        Queue<Pair> q = new LinkedList<>(); // Store task count and available time
        int time = 0;
        
        while (!pq.isEmpty() || !q.isEmpty()) {
            time++;
            
            if (!pq.isEmpty()) {
                int count = pq.poll();
                count--;
                if (count > 0) {
                    q.offer(new Pair(count, time + n));
                }
            }
            
            if (!q.isEmpty() && q.peek().availableTime == time) {
                pq.offer(q.poll().count);
            }
        }
        
        return time;
    }
    
    private static class Pair {
        int count;
        int availableTime;
        Pair(int count, int availableTime) {
            this.count = count;
            this.availableTime = availableTime;
        }
    }
}
