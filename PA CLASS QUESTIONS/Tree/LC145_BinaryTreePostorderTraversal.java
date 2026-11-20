// LeetCode 145: Binary Tree Postorder Traversal
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class LC145_BinaryTreePostorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    // Approach 1: Recursive List Implementation
    public static List<Integer> postorderTraversalRecursive(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode node, List<Integer> result) {
        if (node == null) return;
        helper(node.left, result);
        helper(node.right, result);
        result.add(node.val);
    }

    // Approach 2: Iterative List Implementation (Using Single Stack)
    public static List<Integer> postorderTraversalIterative(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            result.add(curr.val);
            if (curr.left != null) stack.push(curr.left);
            if (curr.right != null) stack.push(curr.right);
        }

        Collections.reverse(result);
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println("Postorder Traversal (Recursive): " + postorderTraversalRecursive(root));
        System.out.println("Postorder Traversal (Iterative): " + postorderTraversalIterative(root));
    }
}
