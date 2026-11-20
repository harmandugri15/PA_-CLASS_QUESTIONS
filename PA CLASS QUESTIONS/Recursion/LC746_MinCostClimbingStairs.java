// LeetCode 746: Min Cost Climbing Stairs
public class LC746_MinCostClimbingStairs {

    // Bottom-Up Space-Optimized O(1) space, O(n) time
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int prev2 = cost[0];
        int prev1 = cost[1];

        for (int i = 2; i < n; i++) {
            int current = cost[i] + Math.min(prev1, prev2);
            prev2 = prev1;
            prev1 = current;
        }
        return Math.min(prev1, prev2);
    }

    public static void main(String[] args) {
        int[] cost = {10, 15, 20};
        System.out.println("Min cost to reach top: " + minCostClimbingStairs(cost)); // 15
    }
}
