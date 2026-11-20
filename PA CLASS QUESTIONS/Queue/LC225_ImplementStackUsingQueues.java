// LeetCode 225: Implement Stack using Queues
import java.util.LinkedList;
import java.util.Queue;

public class LC225_ImplementStackUsingQueues {

    static class MyStack {
        private Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        // Push element x onto stack: O(n) push, O(1) pop
        public void push(int x) {
            q.add(x);
            int size = q.size();
            for (int i = 0; i < size - 1; i++) {
                q.add(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        System.out.println("Top: " + stack.top()); // 2
        System.out.println("Pop: " + stack.pop()); // 2
        System.out.println("Empty: " + stack.empty()); // false
    }
}
