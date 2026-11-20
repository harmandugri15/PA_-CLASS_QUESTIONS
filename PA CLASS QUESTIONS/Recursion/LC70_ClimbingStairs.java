// LeetCode 70: Climbing Stairs
public class LC70_ClimbingStairs {

    // Approach 1: Recursive with Memoization (Top-Down)
    public static int climbStairsMemo(int n, int[] memo) {
        if (n <= 1) return 1;
        if (memo[n] != 0) return memo[n];
        return memo[n] = climbStairsMemo(n - 1, memo) + climbStairsMemo(n - 2, memo);
    }

    // Approach 2: Dynamic Programming / Space Optimized (Bottom-Up)
    public static int climbStairs(int n) {
        if (n <= 2) return n;
        int prev2 = 1;
        int prev1 = 2;
        for (int i = 3; i <= n; i++) {
            int current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return prev1;
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.println("Ways to climb " + n + " stairs (DP): " + climbStairs(n));
        System.out.println("Ways to climb " + n + " stairs (Memo): " + climbStairsMemo(n, new int[n + 1]));
    }
}
