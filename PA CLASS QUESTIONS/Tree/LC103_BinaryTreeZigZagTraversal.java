import java.util.*;


class LC103_BinaryTreeZigZagTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> answer=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null){
            return answer;
        }
        q.offer(root);
        int level=0;
        while(!q.isEmpty()){
            int n=q.size();
            ArrayList<Integer> ans=new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode curr=q.poll();
                ans.add(curr.val);
                if(curr.left!=null){
                    q.offer(curr.left);
                }
                if(curr.right!=null){
                    q.offer(curr.right);
                }
                
            }
            if(level%2!=0){
                Collections.reverse(ans);
            }
            answer.add(ans);
            level++;
        }
        return answer;
    }
}