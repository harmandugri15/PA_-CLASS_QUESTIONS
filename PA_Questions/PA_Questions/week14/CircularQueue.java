class CircularQueue{
    public int[] arr;
    public int front,rear,size,capacity;

    CircularQueue(int capacity){
        arr=new int[capacity];
        this.front=0;
        this.rear=0;
        this.size=0;
    }
    public static void addfirst(int value){}

    public static void main(String[] args) {
        CircularQueue cq=new CircularQueue(5);

    }
}