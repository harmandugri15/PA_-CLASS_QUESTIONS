// LeetCode 901: Online Stock Span
import java.util.Stack;

public class LC901_OnlineStockSpan {

    static class StockSpanner {
        // Monotonic stack storing pairs: [price, span]
        private Stack<int[]> stack;

        public StockSpanner() {
            stack = new Stack<>();
        }

        public int next(int price) {
            int span = 1;
            while (!stack.isEmpty() && stack.peek()[0] <= price) {
                span += stack.pop()[1];
            }
            stack.push(new int[]{price, span});
            return span;
        }
    }

    public static void main(String[] args) {
        StockSpanner spanner = new StockSpanner();
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        System.out.print("Stock Spans: ");
        for (int p : prices) {
            System.out.print(spanner.next(p) + " ");
        }
        System.out.println();
    }
}
