// Hospital Management Priority Queue (Triage System)
import java.util.PriorityQueue;

public class HospitalManagementPriorityQueue {

    static class Patient implements Comparable<Patient> {
        String name;
        int urgency; // Lower number indicates higher medical priority (1: Critical, 5: Minor)
        long arrivalTime;

        public Patient(String name, int urgency, long arrivalTime) {
            this.name = name;
            this.urgency = urgency;
            this.arrivalTime = arrivalTime;
        }

        @Override
        public int compareTo(Patient other) {
            if (this.urgency != other.urgency) {
                return Integer.compare(this.urgency, other.urgency);
            }
            return Long.compare(this.arrivalTime, other.arrivalTime);
        }

        @Override
        public String toString() {
            return "Patient{" + name + ", Urgency=" + urgency + "}";
        }
    }

    public static void main(String[] args) {
        PriorityQueue<Patient> erQueue = new PriorityQueue<>();

        erQueue.add(new Patient("John (Flu)", 4, 1001));
        erQueue.add(new Patient("Alice (Cardiac Arrest)", 1, 1002));
        erQueue.add(new Patient("Bob (Fracture)", 2, 1003));
        erQueue.add(new Patient("Carol (Severe Burns)", 1, 1004));

        System.out.println("Treatment Order by Emergency Priority:");
        while (!erQueue.isEmpty()) {
            System.out.println("Treating: " + erQueue.poll());
        }
    }
}
