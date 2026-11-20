class LC641_DesignCircularDeque {
    
    public int[] arr;
    public int capacity;
    public int front;
    public int rear;
    int size=0;

    public LC641_DesignCircularDeque(int k) {
        arr=new int[k];
        this.capacity=k;
        this.front=0;
        this.rear=0;
    }
    
    public boolean insertFront(int value) {
        if(size==capacity){
            return false;
        }
        else{
            front=(front-1+capacity) % capacity;
            arr[front]=value;
            size++;
            return true;
        }
    }
    
    public boolean insertLast(int value) {
        if(size==capacity){
            return false;
        }
        else{
            arr[rear]=value;
            rear=(rear+1) % capacity;
            size++;
            return true;
        }
    }
    
    public boolean deleteFront() {
        if(size==0){
            return false;
        }
        else{
            front=(front+1) % capacity;
            size--;
            return true;
        }
    }
    
    public boolean deleteLast() {
        if(size==0){
            return false;
        }
        else{
            rear=(rear-1+capacity) % capacity;
            size--;
            return true;
        }
    }
    
    public int getFront() {
        if(isEmpty()){
            return -1;
        }
        return arr[front];
    }
    
    public int getRear() {
        if(isEmpty()){
            return -1;
        }
        return arr[(rear-1+capacity) % capacity];
    }
    
    public boolean isEmpty() {
        if(size==0){
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean isFull() {
        if(size==capacity){
            return true;
        }
        else{
            return false;
        }
    }
}
