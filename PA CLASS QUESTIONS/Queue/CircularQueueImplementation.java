
class CircularQueueImplementation {

    int[] arr;
    int front;
    int rear;
    int size;
    int count;

     CircularQueueImplementation(int size) {
        this.size = size;
        arr = new int[size];
        front = 0;
        rear = -1;
        count = 0;
    }

    public void offer(int x) {
        if (isFull()) {
            System.out.println("full ");
        }

        rear = (rear + 1) % size;
        arr[rear] = x;
        count++;
    }

    public int poll() {
        if (isEmpty()) {
            System.out.println("emopty");
        }

        int x = arr[front];
        front = (front + 1) % size;
        count--;

        return x;
    }

    public int front() {
        if (isEmpty()) {
            System.out.println("emoty");
        }

        return arr[front];
    }

    public int rear() {
        if (isEmpty()) {
            System.out.println("empty");
        }

        return arr[rear];
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public boolean isFull() {
        return count == size;
    }

    public static void main(String[] args) {
        CircularQueueImplementation q = new CircularQueueImplementation(3);

        q.offer(10);
        q.offer(20);
        q.offer(30);

        System.out.println(q.front());
        System.out.println(q.rear());

        System.out.println(q.poll());

        q.offer(40);

        System.out.println(q.front());
        System.out.println(q.rear());
        System.out.println(q.isFull());
    }
}
