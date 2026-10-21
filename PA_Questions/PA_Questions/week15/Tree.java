
import java.util.*;

class Tree {

    int data;
    Tree left;
    Tree right;

    public Tree(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static void inorder(Tree root) {
        if (root == null) {
        } else {
            inorder(root.left);
            System.out.print(root.data + " ");
            inorder(root.right);
        }
    }

    @SuppressWarnings("UnnecessaryReturnStatement")
    public static void preorder(Tree root) {
        if (root == null) {
            return;
        } else {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void postorder(Tree root) {
        if (root == null) {
        } else {
            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    public static void levelorder(Tree root) {
        if (root == null) {
            return;
        }
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Tree curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }

        }
    }

    public static int totalNodes(Tree root) {
        if (root == null) {
            return 0;
        } else {
            return totalNodes(root.left) + totalNodes(root.right) + 1;
        }
    }

    public static int height(Tree root) {
        if (root == null) {
            return 0;
        } else {
            int leftheight = height(root.left);
            int rightheight = height(root.right);
            return Math.max(leftheight, rightheight) + 1;
        }
    }

    public static boolean completeBinaryTree(Tree root) {
        if (root == null) {
            return true;
        }
        Queue<Tree> q = new LinkedList<>();
        q.add(root);

        boolean nullFound = false;

        while (!q.isEmpty()) {
            Tree curr = q.poll();

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
        Tree root = new Tree(0);
        root.left = new Tree(1);
        root.right = new Tree(2);
        root.left.left = new Tree(3);
        root.left.right = new Tree(4);
        root.left.left.left = new Tree(15);

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
