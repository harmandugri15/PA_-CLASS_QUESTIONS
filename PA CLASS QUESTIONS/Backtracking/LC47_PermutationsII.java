import java.util.*;

class LC47_PermutationsII {

    public static void backtrack(int[] nums,boolean[] used,ArrayList<Integer> list,List<List<Integer>> result){
        if(nums.length==list.size()){
            result.add(new ArrayList(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }

            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            list.add(nums[i]);
            used[i]=true;
            backtrack(nums,used,list,result);
            
            list.remove(list.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);
        boolean[] bb=new boolean[nums.length];
        backtrack(nums,bb,new ArrayList<>(),result);
        return result;
    }
}