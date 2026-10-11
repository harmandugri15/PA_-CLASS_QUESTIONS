
class MyQueue {

    int[] arr1;
    int[] arr2;
    int top1;
    int top2;
    int size;

    MyQueue(int size) {
        this.size = size;
        arr1 = new int[size];
        arr2 = new int[size];
        top1 = -1;
        top2 = -1;
    }

    public void enqueue(int x) {
        if (top1 == size - 1) {
            System.out.println("Q is full ");
            return;
        }

        top1++;
        arr1[top1] = x;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Q is empty");
            return -1;
        }

        if (top2 == -1) {
            while (top1 != -1) {
                arr2[++top2] = arr1[top1--];
            }
        }

        return arr2[top2--];
    }

    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }

        if (top2 == -1) {
            while (top1 != -1) {
                arr2[++top2] = arr1[top1--];
            }
        }

        return arr2[top2];
    }

    public boolean isEmpty() {
        return top1 == -1 && top2 == -1;
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue(10);

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println(q.peek());
        System.out.println(q.dequeue());
        System.out.println(q.dequeue());

        q.enqueue(40);

        System.out.println(q.dequeue());
        System.out.println(q.dequeue());
        System.out.println(q.isEmpty());
    }
}
