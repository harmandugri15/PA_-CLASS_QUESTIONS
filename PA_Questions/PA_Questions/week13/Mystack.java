
class Mystack {

    int[] arr;
    int[] minArr;
    int top;
    int size;

    Mystack(int size) {
        this.size = size;
        arr = new int[size];
        minArr = new int[size];
        top = -1;
    }

    public void push(int x) {
        if(top==size-1){
            return;
        }

        top++;
        arr[top] = x;

        if (top == 0) {
            minArr[top] = x;
        } else {
            minArr[top] = Math.min(x, minArr[top - 1]);
        }
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }

        int x = arr[top];
        top--;
        return x;
    }

    public int top() {
        if (top == -1) {
            return -1;
        }

        return arr[top];
    }

    public int getMin() {
        if (top == -1) {
            return -1;
        }

        return minArr[top];
    }

    public static void main(String[] args) {
        Mystack s = new Mystack(10);

        s.push(5);
        s.push(2);
        s.push(7);
        s.push(2);

        System.out.println(s.top());
        System.out.println(s.getMin());

        s.pop();
        s.push(1);

        System.out.println(s.getMin());
    }
}
