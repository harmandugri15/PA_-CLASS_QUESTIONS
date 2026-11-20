
class StandardQueue_RunningAverage {

    public int front;
    public int rear;
    public int[] arr;
    public int size;

    public StandardQueue_RunningAverage(int size) {
        this.front = 0;
        this.rear = 0;
        this.size = size;
        this.arr = new int[this.size];
    }

    public void enqueue(int a) {
        if (rear >= size) {
            System.out.println("StandardQueue_RunningAverage OVRFLOW HO GAYA");
        } else {
            arr[rear++] = a;
        }
    }

    @Override
    public String toString() {
        String result = "[";
        for (int i = front; i < rear; i++) {
            result += arr[i];
            if (i < rear - 1) {
                result += ", ";
            }
        }
        result += "]";
        return result;
    }

    public void dequeue(){
        if(rear==front || front>rear){
            System.out.println("StandardQueue_RunningAverage UNDERFLOW");
        }
        else{
            System.out.println("removed "+arr[front]);
            front++;
        }
    }

    public static void main(String[] args) {
        StandardQueue_RunningAverage q1 = new StandardQueue_RunningAverage(5);
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        q1.enqueue(5);
        System.out.println(q1);
        // q1.add(6);
        q1.dequeue();
        System.out.println(q1);
        q1.dequeue();
        System.out.println(q1);
        q1.dequeue();
        System.out.println(q1);
        q1.enqueue(11);
        System.out.println(q1);
        q1.dequeue();
        System.out.println(q1);
        q1.dequeue();
        System.out.println(q1);
    }
}
