// LeetCode 71: Simplify Path
import java.util.Stack;

public class LC71_SimplifyPath {

    public static String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                continue;
            } else if (part.equals("..")) {
                if (!stack.isEmpty()) stack.pop();
            } else {
                stack.push(part);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/").append(dir);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        String path = "/a/./b/../../c/";
        System.out.println("Simplified path: " + simplifyPath(path)); // "/c"
    }
}
