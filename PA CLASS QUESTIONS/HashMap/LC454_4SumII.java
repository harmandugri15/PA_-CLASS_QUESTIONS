// LeetCode 454: 4Sum II (Sum2 of two pair sums)
import java.util.HashMap;
import java.util.Map;

public class LC454_4SumII {

    public static int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        // Store frequency of every sum of pairs (a + b) from nums1 and nums2
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }

        int count = 0;
        // Check for -(c + d) in the map
        for (int c : nums3) {
            for (int d : nums4) {
                int target = -(c + d);
                count += map.getOrDefault(target, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {-2, -1};
        int[] nums3 = {-1, 2};
        int[] nums4 = {0, 2};

        System.out.println("Number of tuples summing to 0: " + fourSumCount(nums1, nums2, nums3, nums4)); // 2
    }
}
