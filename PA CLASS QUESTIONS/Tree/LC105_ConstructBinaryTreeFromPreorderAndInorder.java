// LeetCode 105: Construct Binary Tree from Preorder and Inorder Traversal
import java.util.HashMap;
import java.util.Map;

public class LC105_ConstructBinaryTreeFromPreorderAndInorder {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) { this.val = val; }
    }

    private static int preorderIndex = 0;
    private static Map<Integer, Integer> inorderIndexMap;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIndex = 0;
        inorderIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }
        return build(preorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootVal = preorder[preorderIndex++];
        TreeNode root = new TreeNode(rootVal);

        int mid = inorderIndexMap.get(rootVal);
        root.left = build(preorder, left, mid - 1);
        root.right = build(preorder, mid + 1, right);

        return root;
    }

    private static void printInorder(TreeNode root) {
        if (root == null) return;
        printInorder(root.left);
        System.out.print(root.val + " ");
        printInorder(root.right);
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode tree = buildTree(preorder, inorder);
        System.out.print("Inorder of reconstructed tree: ");
        printInorder(tree);
        System.out.println();
    }
}
