
class CircularQueueQuestion {

    public int[] arr;
    public int front, rear, size, capacity;

    CircularQueueQuestion(int capacity) {
        arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    public void enqueue(int value) {
        if (size < capacity) {
            rear = (rear + 1) % capacity;
            arr[rear] = value;
            size++;
        } else {
            System.out.println("Queue is full");
        }
    }

    public void dequeue() {
        if (size <= 0) {
            System.out.println("Queue is empty");
        } else {
            front = (front + 1) % capacity;
            size--;
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(arr[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueueQuestion cq = new CircularQueueQuestion(4);
        cq.enqueue(1);
        cq.enqueue(2);
        cq.enqueue(3);
        cq.enqueue(4);

        cq.display();

        cq.dequeue();
        cq.dequeue();

        cq.enqueue(5);
        cq.enqueue(6);

        cq.display();

        cq.dequeue();
        cq.dequeue();
        cq.dequeue();

        cq.enqueue(7);
        cq.enqueue(8);
        cq.enqueue(9);

        cq.display();

    }
}
