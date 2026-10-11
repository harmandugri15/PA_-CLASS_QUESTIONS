
class LinkedList {

    Node head;

    public class Node {

        public int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    LinkedList() {
        this.head = null;
    }

    public Node reversenodesingroupk(Node head, int k) {
        Node curr = head;
        int count = 0;

        while (curr != null && count < k) {
            curr = curr.next;
            count++;
        }
        if (count < k) {
            return head;
        }

        Node prev = null;
        curr = head;
        for (int i = 0; i < k; i++) {
            Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        head.next = reversenodesingroupk(curr, k);

        return prev;
    }

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public void displayLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.value);
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        for (int i = 1; i < 8; i++) {
            list.add(i);
        }

        System.out.println("Original list:");
        list.displayLL();
        list.head=list.reversenodesingroupk(list.head,3);
        System.out.println("After reversing in groups of 3:");
        list.displayLL();
    }
}


// explaination 
// uin this code the time complexity is O(N) and the space complexity is also O(N) this is caused by the recursive call stack that is being used
// to rotate the next group of elements of the linekdlist.