class LC209_MinimumSizeSubarraySum {
    public int minSubArrayLen(int target, int[] nums) {
       int minlen=Integer.MAX_VALUE;
       int left=0;
       int n=nums.length;
       int sum=0;

       for(int right=0;right<n;right++){
        sum+=nums[right];
            while(sum>=target){
                minlen=Math.min(minlen,right-left+1);
                sum-=nums[left]; 
                left++;
            }
            
       }
       if(minlen!=Integer.MAX_VALUE){
        return minlen;
       }
       else{
        return 0;
       }
    }
}