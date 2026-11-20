// Queue Assessment: Question 3 — Priority-Based Lab Access (Priority Queue)
import java.util.PriorityQueue;

public class Q3_PriorityBasedLabAccess {

    static class StudentAccessRequest implements Comparable<StudentAccessRequest> {
        String studentId;
        int rolePriority; // 1: PhD / Faculty, 2: Final Year Research, 3: Undergraduate
        int requestTimestamp;

        public StudentAccessRequest(String studentId, int rolePriority, int requestTimestamp) {
            this.studentId = studentId;
            this.rolePriority = rolePriority;
            this.requestTimestamp = requestTimestamp;
        }

        @Override
        public int compareTo(StudentAccessRequest other) {
            if (this.rolePriority != other.rolePriority) {
                return Integer.compare(this.rolePriority, other.rolePriority);
            }
            return Integer.compare(this.requestTimestamp, other.requestTimestamp);
        }
    }

    public static void main(String[] args) {
        PriorityQueue<StudentAccessRequest> labQueue = new PriorityQueue<>();

        labQueue.add(new StudentAccessRequest("UG_101", 3, 10));
        labQueue.add(new StudentAccessRequest("PhD_301", 1, 15));
        labQueue.add(new StudentAccessRequest("Grad_201", 2, 12));
        labQueue.add(new StudentAccessRequest("PhD_302", 1, 8));

        System.out.println("Allocating Lab Access Seats:");
        while (!labQueue.isEmpty()) {
            StudentAccessRequest req = labQueue.poll();
            System.out.println("Granted Access To: " + req.studentId + " [Priority Tier: " + req.rolePriority + "]");
        }
    }
}
