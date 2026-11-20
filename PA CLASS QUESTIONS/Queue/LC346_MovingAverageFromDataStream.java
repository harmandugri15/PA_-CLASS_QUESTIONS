// LeetCode 346: Moving Average from Data Stream
import java.util.LinkedList;
import java.util.Queue;

public class LC346_MovingAverageFromDataStream {

    static class MovingAverage {
        private Queue<Integer> queue;
        private int capacity;
        private double sum;

        public MovingAverage(int size) {
            this.capacity = size;
            this.queue = new LinkedList<>();
            this.sum = 0;
        }

        public double next(int val) {
            if (queue.size() == capacity) {
                sum -= queue.poll();
            }
            queue.add(val);
            sum += val;
            return sum / queue.size();
        }
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        System.out.println(m.next(1)); // 1.0
        System.out.println(m.next(10)); // 5.5
        System.out.println(m.next(3)); // 4.66667
        System.out.println(m.next(5)); // 6.0
    }
}
