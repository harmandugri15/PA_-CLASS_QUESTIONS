
class CircularQueue {

    public int[] arr;
    public int front, rear, size, capacity;

    CircularQueue(int capacity) {
        arr = new int[capacity];
        this.front = 0;
        this.rear = -1;
        this.size = 0;
        this.capacity=capacity;
    }

    public void enqueue(int value) {
        if (size < capacity) {
            rear=(rear+1) % capacity;
            arr[rear] = value;
            size++;
            System.out.println("value inserted");
        } else {
            System.out.println("Queue is full");
        }
    }
    public void dequeue() {
        if (size<=0) {
            System.out.println("Queue is empty");
        } else {
            System.out.println(arr[front]+" is removed");
            front= (front+1) % capacity;
            size--;
        }
    }
    public void display(){
        for(int i=0;i<size;i++){
            int index=(front+i)%capacity;
            System.out.print(arr[index]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue cq = new CircularQueue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);

        cq.display();

    }
}
