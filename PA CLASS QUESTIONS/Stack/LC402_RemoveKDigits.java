// LeetCode 402: Remove K Digits
import java.util.Stack;

public class LC402_RemoveKDigits {

    public static String removeKdigits(String num, int k) {
        if (k >= num.length()) return "0";

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > digit) {
                stack.pop();
                k--;
            }
            stack.push(digit);
        }

        // If k remaining, remove from top (end)
        while (k > 0 && !stack.isEmpty()) {
            stack.pop();
            k--;
        }

        // Build result and strip leading zeros
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        sb.reverse();

        // Remove leading zeroes
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println("Smallest possible number: " + removeKdigits(num, k)); // "1219"
    }
}
