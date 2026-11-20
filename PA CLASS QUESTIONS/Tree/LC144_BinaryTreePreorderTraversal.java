import java.util.*;

class LC144_BinaryTreePreorderTraversal {
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

    
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr=new ArrayList<>();
        preorder(root,arr);
        return arr;
    }
    public void preorder(TreeNode root,List<Integer> arr){
        if(root==null){
            return;
        }
        arr.add(root.val);
        preorder(root.left,arr);
        preorder(root.right,arr);
    }
}