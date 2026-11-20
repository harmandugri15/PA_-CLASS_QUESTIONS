import java.util.*;

class LC90_SubsetsII {

    public static void pp(int[] nums, int start, ArrayList<Integer> list, List<List<Integer>> result) {
        result.add(new ArrayList<>(list));
        
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            
            list.add(nums[i]);
            pp(nums, i + 1, list, result); 
            list.remove(list.size() - 1);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums); 
        pp(nums, 0, new ArrayList<>(), result);
        return result;
    }
}
