import java.util.*;

class LC46_Permutations {
    public void backtrack(int[] nums,List<List<Integer>> result,ArrayList<Integer> list,boolean[] used){
        if(list.size()==nums.length){
            result.add(new ArrayList(list));
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]){
                continue;
            }
            else{
                list.add(nums[i]);
                used[i]=true;
            }
            backtrack(nums,result,list,used);
            list.remove(list.size()-1);
            used[i]=false;
        }
    }



    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result=new ArrayList();
        boolean[] bb=new boolean[nums.length];
        backtrack(nums,result,new ArrayList<>(),bb);
        return result;
    }
}