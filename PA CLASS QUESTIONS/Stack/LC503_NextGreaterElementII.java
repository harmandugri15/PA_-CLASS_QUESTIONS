import java.util.Stack;

class LC503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        Stack<Integer> st=new Stack<>();
        int[] arr=new int[n];
        for(int i=2*n-1;i>=0;i--){
            int c=i%n;
            while(!st.isEmpty() && st.peek()<=nums[c]){
                st.pop();
            }
            if(!st.isEmpty()){
                arr[c]=st.peek();
            }
            else{
                arr[c]=-1;
            }
            st.push(nums[c]);
        }
        return arr;
    }
}