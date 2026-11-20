
import java.util.*;

class BinaryTree_Iterative_Height_LongestPath {

    int data;
    BinaryTree_Iterative_Height_LongestPath left;
    BinaryTree_Iterative_Height_LongestPath right;

    public BinaryTree_Iterative_Height_LongestPath(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static void inorder(BinaryTree_Iterative_Height_LongestPath root) {
        if (root == null) {
        } else {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void preorder(BinaryTree_Iterative_Height_LongestPath root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(BinaryTree_Iterative_Height_LongestPath root) {
        if (root == null) {
        } else {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void levelorder(BinaryTree_Iterative_Height_LongestPath root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTree_Iterative_Height_LongestPath> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BinaryTree_Iterative_Height_LongestPath curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }

        }
    }

    public static int totalNodes(BinaryTree_Iterative_Height_LongestPath root) {
        if (root == null) {
            return 0;
        } else {
            return totalNodes(root.left) + totalNodes(root.right) + 1;
        }
    }

    public static int height(BinaryTree_Iterative_Height_LongestPath root) {
        if (root == null) {
            return 0;
        } else {
            int leftheight = height(root.left);
            int rightheight = height(root.right);
            return Math.max(leftheight, rightheight) + 1;
        }
    }

    public static boolean completeBinaryTree(BinaryTree_Iterative_Height_LongestPath root) {
        if (root == null) {
            return true;
        }
        Queue<BinaryTree_Iterative_Height_LongestPath> q = new LinkedList<>();
        q.add(root);

        boolean nullFound = false;

        while (!q.isEmpty()) {
            BinaryTree_Iterative_Height_LongestPath curr = q.poll();

            if (curr == null) {
                nullFound = true;
            } else {
                if (nullFound) {
                    return false;
                }
                q.add(curr.left);
                q.add(curr.right);
            }
        }

        return true;
    }

    public static void main(String[] args) {
        BinaryTree_Iterative_Height_LongestPath root = new BinaryTree_Iterative_Height_LongestPath(0);
        root.left = new BinaryTree_Iterative_Height_LongestPath(1);
        root.right = new BinaryTree_Iterative_Height_LongestPath(2);
        root.left.left = new BinaryTree_Iterative_Height_LongestPath(3);
        root.left.right = new BinaryTree_Iterative_Height_LongestPath(4);
        root.left.left.left = new BinaryTree_Iterative_Height_LongestPath(15);

        System.out.print("inorder: ");
        inorder(root);

        System.out.println();

        System.out.print("Preorder: ");
        preorder(root);
        System.out.println();

        System.out.print("postorder: ");
        postorder(root);

        System.out.println();
        System.out.print("Inorder: ");
        levelorder(root);

        System.out.println();
        int a = totalNodes(root);
        System.out.print("TotalNodes: " + a);

        System.out.println();
        int b = height(root);
        System.out.print("Totalheight: " + b);

        System.out.println();
        boolean x = completeBinaryTree(root);
        System.out.print("iscompleteBinaryTree: " + x);
        System.out.println();

    }
}
