
class Postfix {

    int[] arr;
    int top;
    int size;

    Postfix(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    public void push(int x) {
        if (top == size - 1) {
            return;
        }

        top++;
        arr[top] = x;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }

        int x = arr[top];
        top--;
        return x;
    }

    public int evaluate(String exp) {
        String[] tokens = exp.split(" ");

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-")
                    || s.equals("*") || s.equals("/")) {

                int b = pop();
                int a = pop();
                int ans = 0;

                if (s.equals("+")) {
                    ans = a + b;
                } else if (s.equals("-")) {
                    ans = a - b;
                } else if (s.equals("*")) {
                    ans = a * b;
                } else {
                    if (b == 0) {
                        throw new ArithmeticException("Division by zero");
                    }
                    ans = a / b;
                }

                push(ans);
            } else {
                push(Integer.parseInt(s));
            }
        }

        return pop();
    }

    public static void main(String[] args) {
        Postfix p = new Postfix(100);

        String exp = "12 3 4 * + 2 /";

        System.out.println(p.evaluate(exp));
    }
}
