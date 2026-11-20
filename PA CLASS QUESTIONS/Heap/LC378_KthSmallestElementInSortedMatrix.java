// LeetCode 378: Kth Smallest Element in a Sorted Matrix
import java.util.PriorityQueue;

public class LC378_KthSmallestElementInSortedMatrix {

    static class Element implements Comparable<Element> {
        int val;
        int row;
        int col;

        public Element(int val, int row, int col) {
            this.val = val;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(Element other) {
            return Integer.compare(this.val, other.val);
        }
    }

    // Min-Heap approach: O(k log n) time
    public static int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Element> minHeap = new PriorityQueue<>();

        // Add first element of each row
        for (int r = 0; r < Math.min(n, k); r++) {
            minHeap.add(new Element(matrix[r][0], r, 0));
        }

        for (int i = 0; i < k - 1; i++) {
            Element curr = minHeap.poll();
            if (curr.col + 1 < n) {
                minHeap.add(new Element(matrix[curr.row][curr.col + 1], curr.row, curr.col + 1));
            }
        }

        return minHeap.peek().val;
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1,  5,  9},
            {10, 11, 13},
            {12, 13, 15}
        };
        int k = 8;
        System.out.println("The " + k + "th smallest element is: " + kthSmallest(matrix, k)); // 13
    }
}
