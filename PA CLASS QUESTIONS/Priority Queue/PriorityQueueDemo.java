// Priority Queue Demo: Min-Heap, Max-Heap, Custom Comparators
import java.util.Collections;
import java.util.PriorityQueue;

public class PriorityQueueDemo {

    public static void main(String[] args) {
        System.out.println("=== 1. Standard Min-Heap ===");
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(40);
        minHeap.add(10);
        minHeap.add(30);
        minHeap.add(20);

        while (!minHeap.isEmpty()) {
            System.out.print(minHeap.poll() + " "); // 10 20 30 40
        }
        System.out.println();

        System.out.println("=== 2. Max-Heap ===");
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        maxHeap.add(40);
        maxHeap.add(10);
        maxHeap.add(30);
        maxHeap.add(20);

        while (!maxHeap.isEmpty()) {
            System.out.print(maxHeap.poll() + " "); // 40 30 20 10
        }
        System.out.println();
    }
}
