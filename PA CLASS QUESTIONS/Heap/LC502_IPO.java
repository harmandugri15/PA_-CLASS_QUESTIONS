// LeetCode 502: IPO (Maximize Capital with Priority Queue)
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LC502_IPO {

    static class Project implements Comparable<Project> {
        int capital;
        int profit;

        public Project(int capital, int profit) {
            this.capital = capital;
            this.profit = profit;
        }

        @Override
        public int compareTo(Project other) {
            return Integer.compare(this.capital, other.capital);
        }
    }

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        Project[] projects = new Project[n];
        for (int i = 0; i < n; i++) {
            projects[i] = new Project(capital[i], profits[i]);
        }

        Arrays.sort(projects);

        // Max-heap for available profits
        PriorityQueue<Integer> maxProfitHeap = new PriorityQueue<>(Collections.reverseOrder());
        int projectIndex = 0;

        for (int step = 0; step < k; step++) {
            // Add all projects we can currently afford
            while (projectIndex < n && projects[projectIndex].capital <= w) {
                maxProfitHeap.add(projects[projectIndex].profit);
                projectIndex++;
            }

            if (maxProfitHeap.isEmpty()) break;

            // Pick the project that gives maximum profit
            w += maxProfitHeap.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int k = 2, w = 0;
        int[] profits = {1, 2, 3};
        int[] capital = {0, 1, 1};

        System.out.println("Maximized Capital: " + findMaximizedCapital(k, w, profits, capital)); // 4
    }
}
